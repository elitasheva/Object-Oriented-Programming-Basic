package problem3;

public class Chicken {

    private final int AGE_MIN = 0;
    private final int AGE_MAX = 15;
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {

        name = name.trim();

        if (name == null || name.isEmpty() || name.equals("")){
            throw new IllegalArgumentException("The name cannot be null ot empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {

        if (age < AGE_MIN || age > AGE_MAX){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
}
