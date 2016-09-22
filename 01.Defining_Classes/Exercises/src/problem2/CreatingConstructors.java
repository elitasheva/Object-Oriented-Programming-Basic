package problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class CreatingConstructors {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Class personClass = Person.class;
            Constructor emptyConstr = personClass.getDeclaredConstructor();
            Constructor ageConstr = personClass.getDeclaredConstructor(int.class);
            Constructor nameAgeConstr = personClass.getConstructor(String.class, int.class);

            String name = reader.readLine();
            int age = Integer.parseInt(reader.readLine());

            Person basePerson = (Person) emptyConstr.newInstance();
            Person personWithAge = (Person) ageConstr.newInstance(age);
            Person personFull = (Person) nameAgeConstr.newInstance(name, age);

            System.out.printf("%s %s%n", basePerson.getName(), basePerson.getAge());
            System.out.printf("%s %s%n", personWithAge.getName(), personWithAge.getAge());
            System.out.printf("%s %s%n", personFull.getName(), personFull.getAge());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {

    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age) {
        this(DEFAULT_NAME, age);
    }

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}