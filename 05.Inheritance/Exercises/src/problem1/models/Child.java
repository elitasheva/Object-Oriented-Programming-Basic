package problem1.models;

public class Child extends Person {

    private final int MAX_AGE = 15;

    public Child(String name, int age) {

        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > MAX_AGE){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
