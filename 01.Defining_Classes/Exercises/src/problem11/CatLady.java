package problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class CatLady {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            LinkedHashMap<String, Cat> cats = new LinkedHashMap<>();

            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] data = input.split("\\s+");
                String breed = data[0];
                Cat current = null;
                if (breed.equals("Siamese")) {
                    current = new Siamese(data[1], data[0], data[2]);
                    cats.put(data[1], current);
                }
                if (breed.equals("Cymric")) {
                    current = new Cymric(data[1], data[0], data[2]);
                    cats.put(data[1], current);
                }

                if (breed.equals("StreetExtraordinaire")) {
                    current = new StreetExtraordinaire(data[1], data[0], data[2]);
                    cats.put(data[1], current);
                }
            }

            String lastCommand = reader.readLine();
            System.out.println(cats.get(lastCommand).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

abstract class Cat {

    protected String name;
    protected String breed;

    protected Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
}

class Siamese extends Cat {

    private String earSize;

    public Siamese(String name, String breed, String earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", super.breed, super.name, this.earSize);
    }
}

class Cymric extends Cat {

    private String furLenght;

    public Cymric(String name, String breed, String furLenght) {
        super(name, breed);
        this.furLenght = furLenght;
    }

    @Override
    public String toString() {

        return String.format("%s %s %s", super.breed, super.name, this.furLenght);
    }
}

class StreetExtraordinaire extends Cat {

    private String decibelsOfMeowing;

    public StreetExtraordinaire(String name, String breed, String decibelsOfMeowing) {
        super(name, breed);
        this.decibelsOfMeowing = decibelsOfMeowing;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", super.breed, super.name, this.decibelsOfMeowing);

    }
}
