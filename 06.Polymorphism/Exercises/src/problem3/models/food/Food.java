package problem3.models.food;

public abstract class Food {

    private int quantity;
    private String typeFood;

    protected Food(int quantity, String typeFood) {

        this.quantity = quantity;
        this.typeFood = typeFood;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTypeFood() {

        return typeFood;
    }
}
