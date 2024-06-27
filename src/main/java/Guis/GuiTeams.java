package Guis;

import Data.DataPlayer;
import Model.Player;
import Model.Team;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class GuiTeams {
    private JFrame frame;
    private JPanel teamsPanel;
    private JComboBox<String> teamComboBox;
    private JLabel lblTeamInfo;
    private List<Team> teams;
    private DataPlayer dataPlayer;
    private HashMap<String, String> teamFileMapping;

    public GuiTeams(List<Team> teams, DataPlayer dataPlayer) {
        this.teams = teams;
        this.dataPlayer = dataPlayer;
        initializeTeamFileMapping();
        initialize();
    }

    private void initializeTeamFileMapping() {
        teamFileMapping = new HashMap<>();
        teamFileMapping.put("Australia", "aus");
        teamFileMapping.put("Camerún", "cmr");
        teamFileMapping.put("Chile", "chi");
        teamFileMapping.put("Alemania", "ger");
    }

    private void initialize() {
        frame = new JFrame("Selecciones del Campeonato");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        teamsPanel = new JPanel();
        teamsPanel.setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel(new FlowLayout());
        JLabel lblTeams = new JLabel("Selecciones:");
        selectionPanel.add(lblTeams);

        teamComboBox = new JComboBox<>();
        for (Team team : teams) {
            teamComboBox.addItem(team.getName());
        }
        teamComboBox.addActionListener(e -> {
            String selectedTeamName = (String) teamComboBox.getSelectedItem();
            if (selectedTeamName != null) {
                Team selectedTeam = getTeamByName(selectedTeamName);
                if (selectedTeam != null) {
                    showTeamInfo(selectedTeam);
                    showPlayers(selectedTeam.getName());
                }
            }
        });
        selectionPanel.add(teamComboBox);

        teamsPanel.add(selectionPanel, BorderLayout.NORTH);

        lblTeamInfo = new JLabel("Seleccione un equipo para ver la información de los jugadores.");
        teamsPanel.add(lblTeamInfo, BorderLayout.CENTER);

        JButton editButton = new JButton("Editar Jugador");
        editButton.addActionListener(e -> {
            Player selectedPlayer = getSelectedPlayer();
            if (selectedPlayer != null) {
                String newName = JOptionPane.showInputDialog(frame, "Nuevo nombre para el jugador:", selectedPlayer.getName());
                if (newName != null && !newName.isEmpty()) {
                    selectedPlayer.setName(newName);
                    dataPlayer.editPlayer(selectedPlayer);
                    showPlayers((String) teamComboBox.getSelectedItem());
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Seleccione un jugador para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        teamsPanel.add(editButton, BorderLayout.SOUTH);

        frame.add(teamsPanel);
    }

    private Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    private void showTeamInfo(Team team) {
        StringBuilder info = new StringBuilder("<html>");
        info.append("<b>Nombre:</b> ").append(team.getName()).append("<br>");
        info.append("<b>Ranking FIFA:</b> ").append(team.getRanking()).append("<br>");
        info.append("<b>Ruta de la bandera:</b> ").append(team.getFlagIcon()).append("<br>");
        info.append("</html>");
        lblTeamInfo.setText(info.toString());
    }

    private void showPlayers(String teamName) {
        String teamFileName = teamFileMapping.get(teamName);
        System.out.println("Seleccionado equipo: " + teamName + ", archivo: " + teamFileName); // Depuración
        if (teamFileName != null) {
            List<Player> players = dataPlayer.loadPlayersFromFile(teamFileName);
            if (players.isEmpty()) {
                System.out.println("No se cargaron jugadores para el equipo: " + teamName); // Depuración
            } else {
                for (Player player : players) {
                    System.out.println("Jugador: " + player); // Depuración
                }
                // Actualiza la interfaz de jugadores si es necesario
                // En este ejemplo, asumimos que GuiPlayers es una clase separada para mostrar jugadores.
                //guiPlayers.showPlayers(players);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No se encontró el archivo para el equipo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Player getSelectedPlayer() {
        Team selectedTeam = getTeamByName((String) teamComboBox.getSelectedItem());
        if (selectedTeam != null && selectedTeam.getPlayers() != null && !selectedTeam.getPlayers().isEmpty()) {
            return selectedTeam.getPlayers().get(0); // Devuelve el primer jugador como ejemplo
        }
        return null;
    }

    public JFrame getFrame() {
        return frame;
    }
}
