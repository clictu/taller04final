package Guis;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiPlayers {

    private JFrame playersFrame;
    private JPanel playersPanel;

    public GuiPlayers() {
        initialize();
    }

    private void initialize() {
        playersFrame = new JFrame("Jugadores del Equipo");
        playersFrame.setSize(400, 300);

        playersPanel = new JPanel();
        playersPanel.setLayout(new BorderLayout());

        playersFrame.add(playersPanel);
    }

    public void showPlayers(List<Player> players) {
        playersPanel.removeAll();

        JPanel playersListPanel = new JPanel();
        playersListPanel.setLayout(new GridLayout(players.size(), 1));

        for (Player player : players) {
            JLabel playerLabel = new JLabel(player.getNumber() + " - " + player.getName() + " - " + player.getPosition());
            playersListPanel.add(playerLabel);
        }

        JScrollPane scrollPane = new JScrollPane(playersListPanel);
        playersPanel.add(scrollPane, BorderLayout.CENTER);

        playersFrame.setVisible(true);
    }
}
