package problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class PokemonTrainer {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Trainer> trainers = new ArrayList<>();

            while (true) {
                String input = reader.readLine();
                if ("Tournament".equals(input)) {
                    break;
                }

                String[] dataPokemon = input.split("\\s+");
                String trainerName = dataPokemon[0];
                String pokemonName = dataPokemon[1];
                String pokemonElement = dataPokemon[2];
                int pokemonHealth = Integer.parseInt(dataPokemon[3]);

                Trainer currentTrainer = null;
                try {
                    currentTrainer = trainers.stream().filter(t -> t.getName().equals(trainerName)).findFirst().get();

                }catch (NoSuchElementException nsee){
                    currentTrainer = new Trainer(trainerName);
                    trainers.add(currentTrainer);
                }

                Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                currentTrainer.getPokemons().add(currentPokemon);

            }

            while (true) {

                String command = reader.readLine();
                if ("End".equals(command)) {
                    break;
                }

                for (Trainer trainer : trainers) {

                    List<Pokemon> pokemons = trainer.getPokemons()
                            .stream()
                            .filter(p -> p.getElement().equals(command))
                            .collect(Collectors.toList());

                    if (pokemons.size() > 0) {
                        trainer.setBadges(trainer.getBadges() + 1);
                    } else {
                        List<Pokemon> allPokemons = new ArrayList<>(trainer.getPokemons());
                        for (Pokemon pokemon : allPokemons) {

                            try {
                                pokemon.setHealth(pokemon.getHealth()-10);
                            }catch (IllegalArgumentException iae){
                                trainer.getPokemons().remove(pokemon);
                            }
                        }

                    }

                }
            }

            trainers.stream()
                    .sorted((a,b) -> Integer.compare(b.getBadges(), a.getBadges()))
                    .forEach(t -> System.out.printf("%s %d %d%n", t.getName(),t.getBadges(),t.getPokemons().size()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public String getName() {
        return name;
    }
}

class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        if ((health) <= 0) {
            throw new IllegalArgumentException();
        }
        this.health = health;
    }
}
