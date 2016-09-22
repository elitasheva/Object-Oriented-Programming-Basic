package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            AnimalClinic clinic = new AnimalClinic();
            while (true){
                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                String name = params[0];
                String breed = params[1];
                String procedure = params[2];
                Animal animal = new Animal(name,breed);
                clinic.printPatient(animal,procedure);

            }

            System.out.printf("Total healed animals: %d%n", clinic.getHealedAnimals().size());
            System.out.printf("Total rehabilitated animals: %d%n", clinic.getRehabilitedAnimals().size());

            String command = reader.readLine();
            if (command.equals("heal")){

                for (Animal animal : clinic.getHealedAnimals()) {
                    System.out.println(animal);
                }
            }

            if (command.equals("rehabilitate")){

                for (Animal animal : clinic.getRehabilitedAnimals()) {
                    System.out.println(animal);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Animal {
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.breed);
    }
}

class AnimalClinic {

    private static int patientId;
    private List<Animal> healedAnimals;
    private List<Animal> rehabilitedAnimals;

    public AnimalClinic() {
        this.healedAnimals = new ArrayList<>();
        this.rehabilitedAnimals = new ArrayList<>();
        patientId = 1;
    }

    public List<Animal> getHealedAnimals() {
        return healedAnimals;
    }

    public List<Animal> getRehabilitedAnimals() {
        return rehabilitedAnimals;
    }

    public void printPatient(Animal animal, String procedure) {

        if (procedure.equals("rehabilitate")) {
            this.rehabilitedAnimals.add(animal);
            System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n", patientId, animal.getName(), animal.getBreed());
        }

        if (procedure.equals("heal")) {
            this.healedAnimals.add(animal);
            System.out.printf("Patient %d: [%s (%s)] has been healed!%n",patientId, animal.getName(), animal.getBreed());
        }

        patientId++;
    }


}



