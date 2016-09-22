package problem5;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name) {
        setName(name);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {

        if (this.toppings.size() > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings.add(topping);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setName(String name) {

        if (name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setNumberOfToppings(int numberOfToppings) {

        if (numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public double getTotalCalories() {

        double sum = this.dough.getCalories();
        for (Topping topping : toppings) {
            sum += topping.getCalories();
        }

        return sum;
    }


}
