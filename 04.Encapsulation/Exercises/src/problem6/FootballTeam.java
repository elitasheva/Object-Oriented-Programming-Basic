package problem6;

import java.util.LinkedHashMap;

public class FootballTeam {

    private String name;
    private LinkedHashMap<String, Player> players;

    public FootballTeam(String name) {
        setName(name);
        this.players = new LinkedHashMap<>();
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {

        double sum = 0.0;
        for (Player player : players.values()) {
            sum += player.getAverageSkillLevel();
        }

        return sum / this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public void removePlayer(String name) {
        if (!this.players.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        this.players.remove(name);
    }
}
