package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.file.Path;

//Nicole
public class BarraStatus extends JPanel {

    private final JLabel textoStatus;

    public BarraStatus() {
        textoStatus = new JLabel("");

        setLayout(new BorderLayout());
        add(textoStatus, BorderLayout.CENTER);

        setPreferredSize(new Dimension(0, 25));
    }

    public void mostrarArquivo(Path caminho) {
        textoStatus.setText(caminho.toAbsolutePath().toString());
    }

    public void limpar() {
        textoStatus.setText("");
    }
}