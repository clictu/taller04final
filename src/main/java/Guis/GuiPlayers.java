package Guis;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Model.Player;
import Model.Position;

public class GuiPlayers {

    public void displayPlayers(List<Player> players) {
        JFrame frame = new JFrame("Players");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(players.size(), 1));

        for (Player player : players) {
            JLabel label = new JLabel(player.getNumber() + " - " + player.getName() + " (" + player.getPosition() + ")");
            panel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public void editPlayer(Player player) {
        JFrame frame = new JFrame("Edit Player");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(player.getName());
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel numberLabel = new JLabel("Number:");
        JTextField numberField = new JTextField(String.valueOf(player.getNumber()));
        panel.add(numberLabel);
        panel.add(numberField);

        JLabel positionLabel = new JLabel("Position:");
        JComboBox<String> positionBox = new JComboBox<>(new String[]{"GK", "DF", "MF", "FW"});
        positionBox.setSelectedItem(player.getPosition());
        panel.add(positionLabel);
        panel.add(positionBox);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            player.setName(nameField.getText());
            player.setNumber(Integer.parseInt(numberField.getText()));
            player.setPosition(Position.valueOf((String) positionBox.getSelectedItem()));
            // Aquí podrías implementar la lógica para guardar los cambios en los datos
            frame.dispose();
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
