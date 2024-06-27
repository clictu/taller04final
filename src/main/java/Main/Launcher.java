package Main;

import Data.DataPlayer;
import Guis.GuiTeams;
import Model.Player;
import Model.Team;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("01", "Australia", 48, "aus.png"));
            teams.add(new Team("02", "Camerún", 32, "cmr.png"));
            teams.add(new Team("03", "Chile", 12, "chi.png"));
            teams.add(new Team("04", "Alemania", 7, "ger.png"));

            DataPlayer dataPlayer = new DataPlayer();

            GuiTeams guiTeams = new GuiTeams(teams, dataPlayer);

            guiTeams.getFrame().setVisible(true);
        });
    }
}
