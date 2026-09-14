package controller;

import lexico.Constants;
import lexico.LexicalError;
import lexico.Lexico;
import lexico.Token;

import model.Arquivo;
import service.ArquivoService;
import view.AreaMensagens;
import view.BarraFerramentas;
import view.BarraStatus;
import view.Editor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

public class CompiladorController {

    private final Editor editor;
    private final AreaMensagens areaMensagens;
    private final BarraStatus barraStatus;
    private final ArquivoService arquivoService;
    private final Arquivo arquivo;

    public CompiladorController(Editor editor, AreaMensagens areaMensagens, BarraStatus barraStatus,
                                ArquivoService arquivoService, Arquivo arquivo) {
        this.editor = editor;
        this.areaMensagens = areaMensagens;
        this.barraStatus = barraStatus;
        this.arquivoService = arquivoService;
        this.arquivo = arquivo;
    }

    public void registrar(BarraFerramentas barra, JRootPane rootPane) {

        barra.getBtnNovo().addActionListener(this::novo);
        registrarAtalho(rootPane, "novo", KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK, this::novo);

        barra.getBtnAbrir().addActionListener(this::abrir);
        registrarAtalho(rootPane, "abrir", KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK, this::abrir);

        barra.getBtnSalvar().addActionListener(this::salvar);
        registrarAtalho(rootPane, "salvar", KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK, this::salvar);

        barra.getBtnCopiar().addActionListener(e -> editor.getAreaTexto().copy());
        barra.getBtnColar().addActionListener(e -> editor.getAreaTexto().paste());
        barra.getBtnRecortar().addActionListener(e -> editor.getAreaTexto().cut());

        barra.getBtncompilar().addActionListener(this::compilar);
        registrarAtalho(rootPane, "compilar", KeyEvent.VK_F7, 0, this::compilar);

        barra.getBtnEquipe().addActionListener(this::equipe);
        registrarAtalho(rootPane, "equipe", KeyEvent.VK_F1, 0, this::equipe);
    }

    private void registrarAtalho(JRootPane rootPane, String nome, int tecla, int modificador,
                                 Consumer<ActionEvent> acao) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(tecla, modificador);
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, nome);
        rootPane.getActionMap().put(nome, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao.accept(e);
            }
        });
    }

    private void novo(ActionEvent e) {
        editor.limpar();
        areaMensagens.limpar();
        barraStatus.limpar();
        arquivo.limpar(); // "esquece" a pasta e o nome do arquivo editado
    }

    private void abrir(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de texto (*.txt)", "txt"));

        int resultado = fileChooser.showOpenDialog(SwingUtilities.getWindowAncestor(editor));

        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File arquivoSelecionado = fileChooser.getSelectedFile();
        try {
            String conteudo = arquivoService.abrir(arquivoSelecionado.toPath());
            editor.setTexto(conteudo);
            areaMensagens.limpar();
            arquivo.setCaminho(arquivoSelecionado.toPath());
            barraStatus.mostrarArquivo(arquivo.getCaminho());
        } catch (IOException ex) {
            areaMensagens.limpar();
            areaMensagens.mostrarMensagem("Erro ao abrir o arquivo: " + ex.getMessage());
        }
    }

    private void salvar(ActionEvent e) {
        if (arquivo.isNovo()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de texto (*.txt)", "txt"));

            int resultado = fileChooser.showSaveDialog(SwingUtilities.getWindowAncestor(editor));
            if (resultado != JFileChooser.APPROVE_OPTION) {
                return;
            }

            Path caminho = garantirExtensaoTxt(fileChooser.getSelectedFile().toPath());
            try {
                arquivoService.salvar(caminho, editor.getTexto());
                arquivo.setCaminho(caminho);
                areaMensagens.limpar();
                barraStatus.mostrarArquivo(caminho); // arquivo passou a existir: atualiza status
            } catch (IOException ex) {
                areaMensagens.limpar();
                areaMensagens.mostrarMensagem("Erro ao salvar o arquivo: " + ex.getMessage());
            }
        } else {
            try {
                arquivoService.salvar(arquivo.getCaminho(), editor.getTexto());
                areaMensagens.limpar();
                // barra de status mantida - continua mostrando o mesmo caminho (item 12.2)
            } catch (IOException ex) {
                areaMensagens.limpar();
                areaMensagens.mostrarMensagem("Erro ao salvar o arquivo: " + ex.getMessage());
            }
        }
    }

    private Path garantirExtensaoTxt(Path caminho) {
        String nome = caminho.toString();
        if (!nome.toLowerCase().endsWith(".txt")) {
            return caminho.resolveSibling(caminho.getFileName() + ".txt");
        }
        return caminho;
    }

    private void compilar(ActionEvent e) {
        areaMensagens.limpar();

        String codigo = editor.getTexto();

        Lexico lexico = new Lexico();
        lexico.setInput(codigo);

        StringBuilder resultado = new StringBuilder();

        resultado.append(
                String.format(
                        "%-10s %-25s %s%n",
                        "linha",
                        "classe",
                        "lexema"
                )
        );

        try {
            Token t = null;

            while ((t = lexico.nextToken()) != null) {
                int linha = calcularLinha(codigo, t.getPosition());

                if (t.getId() == Constants.t_palavra_reservada) {
                    areaMensagens.mostrarMensagem(
                            "linha " + linha + ": "
                                    + t.getLexeme()
                                    + " palavra reservada inválida"
                    );
                    return;
                }

                String classe = obterClasse(t.getId());

                resultado.append(
                        String.format(
                                "%-10d %-25s %s%n",
                                linha,
                                classe,
                                t.getLexeme()
                        )
                );
            }

            resultado.append("\nprograma compilado com sucesso");
            areaMensagens.mostrarMensagem(resultado.toString());

        } catch (LexicalError erro) {
            int linha = calcularLinha(codigo, erro.getPosition());

            areaMensagens.mostrarMensagem(
                    montarMensagemErro(codigo, erro, linha)
            );
        }
    }

    private int calcularLinha(String codigo, int posicao) {
        int linha = 1;

        for (int i = 0; i < posicao && i < codigo.length(); i++) {
            if (codigo.charAt(i) == '\n') {
                linha++;
            }
        }

        return linha;
    }

    private String obterClasse(int id) {
        if (id >= Constants.t_and && id <= Constants.t_while) {
            return "palavra reservada";
        }

        if (id >= Constants.t_TOKEN_22
                && id <= Constants.t_TOKEN_39) {
            return "símbolo especial";
        }

        switch (id) {
            case Constants.t_identificador_int:
            case Constants.t_identificador_float:
            case Constants.t_identificador_string:
            case Constants.t_identificador_bool:
                return "identificador";

            case Constants.t_const_int:
                return "constante_int";

            case Constants.t_const_float:
                return "constante_float";

            case Constants.t_const_string:
                return "constante_string";

            default:
                return "";
        }
    }

    private String montarMensagemErro(
            String codigo,
            LexicalError erro,
            int linha
    ) {
        String descricao = erro.getMessage();

        if ("símbolo inválido".equals(descricao)) {
            String simbolo = "";

            if (erro.getPosition() < codigo.length()) {
                simbolo = String.valueOf(
                        codigo.charAt(erro.getPosition())
                );
            }

            return "linha " + linha + ": "
                    + simbolo + " símbolo inválido";
        }

        return "linha " + linha + ": " + descricao;
    }

    private void equipe(ActionEvent e) {
        areaMensagens.limpar();
        areaMensagens.mostrarMensagem("Equipe de desenvolvimento:\nNicole Bruch\nVeyda Cristina Barbosa\nVitor W.");
    }
}