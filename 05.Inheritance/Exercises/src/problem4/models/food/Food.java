package problem4.models.food;

public abstract class Food {

    private int points;

    protected Food(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
