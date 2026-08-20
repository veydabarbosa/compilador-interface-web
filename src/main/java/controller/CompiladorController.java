package controller;

//Vitor e Nicole

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
import java.util.function.Consumer;

public class CompiladorController {
    private final Editor editor;
    private final AreaMensagens areaMensagens;
    private final BarraStatus barraStatus;
    private final ArquivoService arquivoService;

    public CompiladorController (Editor editor, AreaMensagens areaMensagens, BarraStatus barraStatus, ArquivoService arquivoService){
        this.editor = editor;
        this.areaMensagens = areaMensagens;
        this.barraStatus = barraStatus;
        this.arquivoService = arquivoService;
    }

    public void registrar(BarraFerramentas barra, JRootPane rootPane){
        barra.getBtnAbrir().addActionListener(this::abrir);
        registrarAtalho(rootPane, "abrir", KeyEvent.VK_0, InputEvent.CTRL_DOWN_MASK, this::abrir);

        barra.getBtnCopiar().addActionListener(e -> editor.getTextArea().copy());
        barra.getBtnColar().addActionListener(e -> editor.getTextArea().paste());
        barra.getBtnRecortar().addActionListener(e -> editor.getTextArea().cut());
        barra.getBtncompilar().addActionListener(this::compilar);
        registrarAtalho(rootPane, "compilar", KeyEvent.VK_F7, 0, this::compilar);
        barra.getBtnEquipe().addActionListener(this::equipe);
        registrarAtalho(rootPane, "equipe", KeyEvent.VK_F1, 0 , this::equipe);
    }

    private void registrarAtalho(JRootPane rootPane, String nome, int tecla, int modificador, Consumer<ActionEvent> acao) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(tecla, modificador);
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, nome);
        rootPane.getActionMap().put(nome, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao.accept(e);
            }
        });
    }

    /*
    private void abrir (ActionEvent e){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de texto (*.txt)", "txt"));

        int resultado = fileChooser.showOpenDialog(SwingUtilities.getWindowAncestor(editor));

        if (resultado != JFileChooser.APPROVE_OPTION){
            return;
        }

        File arquivoSelecionado = fileChooser.getSelectedFile();
        try {
            Arquivo arquivo = arquivoService.abrir(arquivoSelecionado);
            editor.setConteudo(arquivo.getConteudo());
        }
    }
    */
}
