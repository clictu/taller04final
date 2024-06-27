package Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String id;
    private String name;
    private int ranking;
    private String flagIcon;
    private List<Player> players;

    public Team(String id, String name, int ranking, String flagIcon) {
        this.id = id;
        this.name = name;
        this.ranking = ranking;
        this.flagIcon = flagIcon;
        this.players = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    public String getFlagIcon() {
        return flagIcon;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ranking=" + ranking +
                ", flagIcon='" + flagIcon + '\'' +
                '}';
    }
}
