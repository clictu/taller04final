package Data;

import Model.Player;
import Model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {
    private static final String DATA_FOLDER = "C:\\Users\\usuario\\IdeaProjects\\taller04final\\Datos\\";

    public List<Player> loadPlayersFromFile(String teamFileName) {
        List<Player> players = new ArrayList<>();
        String filePath = DATA_FOLDER + teamFileName + ".txt"; // Incluye la extensión .txt

        System.out.println("Intentando cargar archivo: " + filePath); // Depuración

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String position = parts[2];
                    int number = Integer.parseInt(parts[0]); // Asegurar que el número sea el primer elemento en el archivo
                    players.add(new Player(id, name, Position.fromString(position), number));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }
}
