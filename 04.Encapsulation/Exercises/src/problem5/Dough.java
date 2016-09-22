package problem5;

public class Dough {

    private final double FLOUR_TYPE_WHITE = 1.5;
    private final double FLOUR_TYPE_WHOLEGRAIN = 1.0;
    private final double TEHNIQUE_CRISPY = 0.9;
    private final double TEHNIQUE_CHEWY = 1.1;
    private final double TEHNIQUE_HOMEMADE = 1.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType) {

        if (!flourType.equals("white") && !flourType.equals("wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {

        if (!bakingTechnique.equals("crispy") && !bakingTechnique.equals("chewy") && !bakingTechnique.equals("homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {

        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        double calories = 2 * this.weight;
        if (this.flourType.equals("white")) {
            calories *= FLOUR_TYPE_WHITE;
        } else if (this.flourType.equals("wholegrain")) {
            calories *= FLOUR_TYPE_WHOLEGRAIN;
        }

        if (this.bakingTechnique.equals("crispy")) {
            calories *= TEHNIQUE_CRISPY;
        } else if (this.bakingTechnique.equals("chewy")) {
            calories *= TEHNIQUE_CHEWY;
        } else if (this.bakingTechnique.equals("homemade")) {
            calories *= TEHNIQUE_HOMEMADE;
        }

        return calories;
    }
}
