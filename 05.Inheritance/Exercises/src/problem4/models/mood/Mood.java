package problem4.models.mood;

public abstract class Mood {

    private String name;

    protected Mood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
