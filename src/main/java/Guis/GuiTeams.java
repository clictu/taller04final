package Guis;

import javax.swing.*;
import java.awt.*;

public class GuiTeams {

    public void displayTeams() {
        // Aquí se implementaría la lógica para mostrar las selecciones en una interfaz gráfica
        JFrame frame = new JFrame("Super Copa 2024");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));  // Suponiendo 4 selecciones para este ejemplo

        // Aquí se agregarían los detalles de cada selección en paneles o listas
        JLabel labelAus = new JLabel("Australia");
        panel.add(labelAus);

        JLabel labelCmr = new JLabel("Cameroon");
        panel.add(labelCmr);

        JLabel labelChi = new JLabel("Chile");
        panel.add(labelChi);

        JLabel labelGer = new JLabel("Germany");
        panel.add(labelGer);

        frame.add(panel);
        frame.setVisible(true);
    }
}
