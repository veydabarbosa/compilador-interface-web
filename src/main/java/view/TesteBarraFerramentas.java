package view;

import javax.swing.*;
import java.awt.*;

public class TesteBarraFerramentas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste - Barra de Ferramentas");
        frame.setSize(1500, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BarraFerramentas barra = new BarraFerramentas();
        frame.add(barra, BorderLayout.WEST);

        frame.setVisible(true);
    }
}