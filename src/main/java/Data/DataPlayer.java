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
        String filePath = DATA_FOLDER + teamFileName + ".txt";

        System.out.println("Intentando cargar archivo: " + filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String position = parts[2].trim();

                    // Convertir posición a enumeración Position
                    Position pos = Position.fromString(position);
                    if (pos != null) {
                        players.add(new Player(id, name, pos.toString()));
                    } else {
                        System.err.println("Posición inválida encontrada: " + position);
                    }
                } else {
                    System.err.println("Formato incorrecto de línea: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }
}
