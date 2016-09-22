package problem3;

import problem3.models.animals.*;
import problem3.models.food.Food;
import problem3.models.food.Meat;
import problem3.models.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String inputAnimal = reader.readLine();
                if ("End".equals(inputAnimal)) {
                    break;
                }

                String inputFood = reader.readLine();

                Animal animal = createAnimal(inputAnimal);
                Food food = createFood(inputFood);
                animal.makeSound();
                animal.eat(food);
                System.out.println(animal.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Food createFood(String input) {
        String[] params = input.split("\\s+");
        String typeFood = params[0];
        Integer quantity = 0;
        switch (typeFood) {
            case "Vegetable":
                quantity = Integer.parseInt(params[1]);
                return new Vegetable(quantity, typeFood);
            case "Meat":
                quantity = Integer.parseInt(params[1]);
                return new Meat(quantity, typeFood);
            default:
                return null;
        }
    }

    private static Animal createAnimal(String input) {
        String[] params = input.split("\\s+");
        String typeAnimal = params[0];
        Double weight = 0.0;
        switch (typeAnimal) {
            case "Cat":
                weight = Double.parseDouble(params[2]);
                return new Cat(params[1], typeAnimal, weight, params[3], params[4]);
            case "Tiger":
                weight = Double.parseDouble(params[2]);
                return new Tiger(params[1], typeAnimal, weight, params[3]);
            case "Zebra":
                weight = Double.parseDouble(params[2]);
                return new Zebra(params[1], typeAnimal, weight, params[3]);
            case "Mouse":
                weight = Double.parseDouble(params[2]);
                return new Mouse(params[1], typeAnimal, weight, params[3]);
            default:
                return null;
        }
    }
}
