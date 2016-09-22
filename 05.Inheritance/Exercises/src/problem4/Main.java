package problem4;

import problem4.factory.FoodFactory;
import problem4.factory.MoodFactory;
import problem4.models.Gandalf;
import problem4.models.food.Food;
import problem4.models.mood.Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Gandalf gandalf = new Gandalf();
            String[] input = reader.readLine().split("\\s+");
            for (String foodStr : input) {

                Food current = FoodFactory.createFood(foodStr.toLowerCase());
                gandalf.setPointsOfHappines(gandalf.getPointsOfHappines() + current.getPoints());
            }

            Mood mood = MoodFactory.create(gandalf.getPointsOfHappines());

            System.out.println(gandalf.getPointsOfHappines());
            System.out.println(mood.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
