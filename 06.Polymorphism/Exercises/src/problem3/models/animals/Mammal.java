package problem3.models.animals;

import problem3.models.food.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                df.format(super.getAnimalWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (food.getTypeFood().equals("Vegetable")) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            System.out.println(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
        }
    }
}
