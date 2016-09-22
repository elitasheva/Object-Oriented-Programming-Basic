package problem5;

public class Topping {

    private final double TYPE_MEAT = 1.2;
    private final double TYPE_VEGGIES = 0.8;
    private final double TYPE_CHEESE = 1.1;
    private final double TYPE_SAUCE = 0.9;

    private String type;
    private double weight;

    public Topping(String type, double weight) {
        setType(type);
        setWeight(weight);
    }

    public void setType(String type) {

        if (!type.equals("meat") && !type.equals("veggies") && !type.equals("cheese") && !type.equals("sauce")){
            String output = type.substring(0, 1).toUpperCase() + type.substring(1);
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", output));
        }
        this.type = type;
    }

    public void setWeight(double weight) {

        if (weight < 1 || weight > 50){
            String output = type.substring(0, 1).toUpperCase() + type.substring(1);
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",output));
        }
        this.weight = weight;
    }

    public double getCalories(){

        double calories = 2 * this.weight;
        switch (type){
            case "meat":
                calories*=TYPE_MEAT;break;
            case "veggies":
                calories*=TYPE_VEGGIES;break;
            case "cheese":
                calories*=TYPE_CHEESE;break;
            case "sauce":
                calories*=TYPE_SAUCE;break;
        }

        return calories;
    }
}
