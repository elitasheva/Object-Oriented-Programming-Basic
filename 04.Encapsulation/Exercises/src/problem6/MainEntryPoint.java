package problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            LinkedHashMap<String, FootballTeam> teamsByName = new LinkedHashMap<>();
            while (true) {

                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] params = input.split(";");
                String command = params[0];
                String teamName = "";
                String playerName = "";
                try {
                    switch (command) {
                        case "Team":
                            teamName = params[1];
                            if (!teamsByName.containsKey(teamName)) {
                                teamsByName.put(teamName, new FootballTeam(teamName));
                            }
                            break;
                        case "Add":
                            teamName = params[1];
                            if (!teamsByName.containsKey(teamName)) {
                                throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                            } else {
                                playerName = params[2];
                                int endurance = Integer.parseInt(params[3]);
                                int sprint = Integer.parseInt(params[4]);
                                int dribble = Integer.parseInt(params[5]);
                                int passing = Integer.parseInt(params[6]);
                                int shooting = Integer.parseInt(params[7]);
                                Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                                FootballTeam currentTeam = teamsByName.get(teamName);
                                currentTeam.addPlayer(player);
                            }
                            break;
                        case "Remove":
                            teamName = params[1];
                            playerName = params[2];
                            FootballTeam currentTeam = teamsByName.get(teamName);
                            currentTeam.removePlayer(playerName);
                            break;
                        case "Rating":
                            teamName = params[1];
                            if (!teamsByName.containsKey(teamName)){
                                throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                            }
                            FootballTeam team = teamsByName.get(teamName);
                            double rating = team.getRating();
                            System.out.printf("%s - %d%n", teamName, (int)Math.round(rating));
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
