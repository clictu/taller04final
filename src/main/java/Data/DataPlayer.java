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
        String filePath = DATA_PATH + teamFileName + ".txt";
        System.out.println("Intentando cargar jugadores desde: " + filePath); // Depuración

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Leyendo línea: " + line); // Depuración
                String[] data = line.split(";");
                if (data.length == 3) {
                    int number = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String position = data[2].trim();

                    Player player = new Player(number, name, 0, position); // Aquí asumo edad como 0, ajusta según tus datos
                    players.add(player);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line); // Depuración
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + filePath);
            e.printStackTrace();
        }

        System.out.println("Jugadores cargados: " + players.size()); // Depuración
        return players;
    }

    public void editPlayer(Player player) {
        // Implementación para editar un jugador (si es necesario)
    }
}
