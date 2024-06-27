package Data;

import Model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {
    private static final String DATA_PATH = "C:\\Users\\usuario\\IdeaProjects\\taller04final\\Datos\\";

    public List<Player> loadPlayersFromFile(String teamFileName) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PATH + teamFileName + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    String position = data[2].trim();
                    Player player = new Player(name, age, position);
                    players.add(player);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    public void editPlayer(Player player) {
        // Implementación para editar un jugador (si es necesario)
    }
}
