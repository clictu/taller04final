package Data;

import Model.Player;
import Model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {

    private static final String DATA_FOLDER = "Data/";

    // Método para cargar jugadores desde un archivo
    public List<Player> loadPlayersFromFile(String teamId) {
        List<Player> players = new ArrayList<>();
        String fileName = DATA_FOLDER + teamId + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int number = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Position position = Position.valueOf(parts[2]);  // Convertir String a enum Position
                    Player player = new Player(number, name, position);
                    players.add(player);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Método para guardar jugadores en un archivo
    public void savePlayersToFile(String teamId, List<Player> players) {
        String fileName = DATA_FOLDER + teamId + ".txt";
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Player player : players) {
                fw.write(player.getNumber() + ";" + player.getName() + ";" + player.getPosition().toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
