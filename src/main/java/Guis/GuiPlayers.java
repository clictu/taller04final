package Guis;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiPlayers {

    private JFrame frame;
    private JPanel playersPanel;
    private JList<String> playersList;
    private DefaultListModel<String> playersListModel;

    public GuiPlayers() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Jugadores del equipo");
        frame.setSize(400, 300);

        playersPanel = new JPanel(new BorderLayout());

        playersListModel = new DefaultListModel<>();
        playersList = new JList<>(playersListModel);
        JScrollPane scrollPane = new JScrollPane(playersList);
        playersPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(playersPanel);
    }

    public void showPlayers(List<Player> players) {
        playersListModel.clear();
        for (Player player : players) {
            // Aquí se añade cada jugador al modelo de la lista
            playersListModel.addElement(player.getNumber() + " - " + player.getName() + " - " + player.getPosition());
        }
        frame.setVisible(true); // Hace visible la ventana con la lista actualizada de jugadores
    }

    public JFrame getFrame() {
        return frame;
    }
}
