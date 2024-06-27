package Main;

import Data.DataPlayer;
import Guis.GuiTeams;
import Model.Player;
import Model.Position;
import Model.Team;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Datos de prueba
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("01", "Australia", 48, "aus.png"));
            teams.add(new Team("02", "Cameroon", 32, "cmr.png"));
            teams.add(new Team("03", "Chile", 12, "chi.png"));
            teams.add(new Team("04", "Germany", 7, "ger.png"));

            // Inicializar DataPlayer para manejar datos de jugadores
            DataPlayer dataPlayer = new DataPlayer();

            // Crear GUI de selecciones
            GuiTeams guiTeams = new GuiTeams(teams, dataPlayer);

            // Mostrar GUI de selecciones
            guiTeams.getFrame().setVisible(true);
        });
    }
}
