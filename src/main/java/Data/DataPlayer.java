package Data;

import Model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {
    private static final String DATA_FOLDER = "C:\\Users\\usuario\\IdeaProjects\\taller04final\\Datos\\";

    public List<Player> loadPlayersFromFile(String teamFileName) {
        List<Player> players = new ArrayList<>();
        String filePath = DATA_FOLDER + teamFileName + ".txt";

        System.out.println("Intentando cargar archivo: " + filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int number = Integer.parseInt(parts[0]); // Número de jugador
                    String name = parts[1];
                    String position = parts[2];
                    players.add(new Player(number, name, position));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }
}
