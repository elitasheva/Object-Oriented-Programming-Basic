package problem3.models.animals;

import problem3.models.food.Food;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);

    }

    @Override
    public void makeSound() {

        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {

        if (food.getTypeFood().equals("Meat")) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            System.out.println(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
        }
    }
}
