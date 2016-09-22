package problem1.models;

public class Person {

    private final int MIN_LENGTH_NAME = 3;
    private final int MIN_AGE = 1;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name.length() < MIN_LENGTH_NAME){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < MIN_AGE){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d", this.getName(), this.getAge()));
        return sb.toString();
    }
}
