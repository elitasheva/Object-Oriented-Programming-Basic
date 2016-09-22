package problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OpinionPoll {

    public static void main(String[] args) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            List<Person> persons = new ArrayList<>();
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] data = reader.readLine().split("\\s+");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                Person person = new Person(name,age);
                persons.add(person);
            }

            persons
                    .stream()
                    .filter(p -> p.getAge() > 30)
                    .sorted(Person::compareTo)
                    .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person implements Comparable<Person>{

    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age){
        this(DEFAULT_NAME,age);
    }

    public Person(){
        this(DEFAULT_NAME,DEFAULT_AGE);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        return this.getName().compareTo(other.getName());
    }
}