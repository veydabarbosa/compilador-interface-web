package view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Nicole
public class AreaMensagens extends JScrollPane {

    private final JTextArea areaTexto;

    public AreaMensagens() {
        areaTexto = new JTextArea();

        areaTexto.setEditable(false);
        areaTexto.setLineWrap(false);

        setViewportView(areaTexto);

        setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );

        setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
    }

    public void mostrarMensagem(String mensagem) {
        areaTexto.setText(mensagem);
    }

    public void limpar() {
        areaTexto.setText("");
    }
}