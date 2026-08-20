package view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Veyda
public class Editor extends JScrollPane {

    private final JTextArea areaTexto;

    public Editor() {
        areaTexto = new JTextArea();

        areaTexto.setLineWrap(false);
        areaTexto.setBorder(new NumberedBorder());

        setViewportView(areaTexto);

        setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );

        setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    public String getTexto() {
        return areaTexto.getText();
    }

    public void setTexto(String texto) {
        areaTexto.setText(texto);
        areaTexto.setCaretPosition(0);
    }

    public void limpar() {
        areaTexto.setText("");
    }
}