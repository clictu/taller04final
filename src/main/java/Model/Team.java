package Model;

public class Team {
    private String id;
    private String name;
    private int ranking;
    private String flagIcon;

    public Team(String id, String name, int ranking, String flagIcon) {
        this.id = id;
        this.name = name;
        this.ranking = ranking;
        this.flagIcon = flagIcon;
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
}
