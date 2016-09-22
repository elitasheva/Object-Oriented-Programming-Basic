package problem6;

import problem6.models.Animal;
import problem6.models.AnimalFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                String input = reader.readLine();
                if ("Beast!".equals(input)) {
                    break;
                }

                String type = input;
                String[] params = reader.readLine().split("\\s+");
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                String gender = null;
                if (params.length > 2) {
                    gender = params[2];
                }
                try {
                    Animal animal = AnimalFactory.create(type, name, age, gender);

                    System.out.println(animal.toString());
                    System.out.println(animal.produceSound());

                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
