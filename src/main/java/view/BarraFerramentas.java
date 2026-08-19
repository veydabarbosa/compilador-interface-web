package view;

import javax.swing.*;
import java.awt.*;

public class BarraFerramentas extends JPanel {

    private final JButton btnNovo;
    private final JButton btnAbrir;
    private final JButton btnSalvar;
    private final JButton btnCopiar;
    private final JButton btnColar;
    private final JButton btnRecortar;
    private final JButton btncompilar;
    private final JButton btnEquipe;

    public BarraFerramentas() {
        setLayout(new GridLayout(0, 1, 0, 4));
        setPreferredSize(new Dimension(150, 0));

        btnNovo = criarBotao("Novo", "Ctrl+N", "novo.png");
        btnAbrir = criarBotao("Abrir", "Ctrl+O", "abrir.png");
        btnSalvar = criarBotao("Salvar", "Ctrl+S", "salvar.png");
        btnCopiar = criarBotao("Copiar", "Ctrl+C", "copiar.png");
        btnColar = criarBotao("Colar", "Ctrl+V", "colar.png");
        btnRecortar = criarBotao("Recortar", "Ctrl+X", "recortar.png");
        btncompilar = criarBotao("Compilar", "F7", "compilar.png");
        btnEquipe = criarBotao("Equipe", "F1", "equipe.png");

        add(btnNovo);
        add(btnAbrir);
        add(btnSalvar);
        add(btnCopiar);
        add(btnColar);
        add(btnRecortar);
        add(btncompilar);
        add(btnEquipe);
    }

    private JButton criarBotao(String nome, String atalho, String nomeIcone) {
        JButton botao = new JButton();
        botao.setText("<html><center>" + nome + "<br><small>[" + atalho + "]</small></center></html>");

        ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/icons/" + nomeIcone));
        Image imagemRedimensionada = iconeOriginal.getImage()
                .getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        botao.setIcon(new ImageIcon(imagemRedimensionada));

        botao.setHorizontalTextPosition(SwingConstants.CENTER);
        botao.setVerticalTextPosition(SwingConstants.BOTTOM);
        botao.setPreferredSize(new Dimension(140, 70));
        botao.setFocusPainted(false);
        return botao;
    }

    public JButton getBtnNovo() {
        return btnNovo;
    }

    public JButton getBtnAbrir() {
        return btnAbrir;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCopiar() {
        return btnCopiar;
    }

    public JButton getBtnColar() {
        return btnColar;
    }

    public JButton getBtnRecortar() {
        return btnRecortar;
    }

    public JButton getBtncompilar() {
        return btncompilar;
    }

    public JButton getBtnEquipe() {
        return btnEquipe;
    }
}