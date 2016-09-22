package problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Pizza pizza = null;
            while (true) {

                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }


                String[] params = input.split("\\s+");
                String ingredient = params[0].toLowerCase();

                if (ingredient.equals("pizza")) {
                    String pizzaName = params[1];
                    try {
                        pizza = new Pizza(pizzaName);
                        int numberOfTopings = Integer.parseInt(params[2]);
                        pizza.setNumberOfToppings(numberOfTopings);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                }

                if (ingredient.equals("dough")) {
                    String flourType = params[1].toLowerCase();
                    String bakingTechnique = params[2].toLowerCase();
                    double weight = Double.parseDouble(params[3]);

                    try {
                        Dough dough = new Dough(flourType, bakingTechnique, weight);
                        if (pizza != null) {
                            pizza.setDough(dough);
                        } else {
                            double calories = dough.getCalories();
                            System.out.printf("%.2f%n",calories);
                        }

                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                }


                if (ingredient.equals("topping")) {
                    String type = params[1].toLowerCase();
                    double weight = Double.parseDouble(params[2]);
                    try {
                        Topping topping = new Topping(type, weight);

                        if (pizza != null) {
                            pizza.addTopping(topping);
                        } else {
                            double calories = topping.getCalories();
                            System.out.printf("%.2f%n",calories);
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }

            if (pizza != null) {
                double calories = pizza.getTotalCalories();
                System.out.printf("%s - %.2f Calories.", pizza.getName(), calories);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
