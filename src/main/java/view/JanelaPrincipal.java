package view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

//Veyda
public class JanelaPrincipal extends JFrame {

    private final BarraFerramentas barraFerramentas;
    private final Editor editor;
    private final AreaMensagens areaMensagens;
    private final BarraStatus barraStatus;
    private final JSplitPane divisao;

    public JanelaPrincipal() {
        super("Compilador");

        barraFerramentas = new BarraFerramentas();
        editor = new Editor();
        areaMensagens = new AreaMensagens();
        barraStatus = new BarraStatus();

        divisao = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                editor,
                areaMensagens
        );

        divisao.setResizeWeight(0.7);

        setSize(1500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(barraFerramentas, BorderLayout.WEST);
        add(divisao, BorderLayout.CENTER);
        add(barraStatus, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public BarraFerramentas getBarraFerramentas() {
        return barraFerramentas;
    }

    public Editor getEditor() {
        return editor;
    }

    public AreaMensagens getAreaMensagens() {
        return areaMensagens;
    }

    public BarraStatus getBarraStatus() {
        return barraStatus;
    }

    public JSplitPane getDivisao() {
        return divisao;
    }
}