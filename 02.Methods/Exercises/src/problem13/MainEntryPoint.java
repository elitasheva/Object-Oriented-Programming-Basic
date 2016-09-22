package problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            List<Person> persons = new ArrayList<>();

            while (true){

                String input = reader.readLine();
                if ("END".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                String occupation = params[2];
                Person current = new Person(name,age,occupation);
                persons.add(current);
            }

            persons.stream().sorted().forEach(p -> System.out.println(p));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {

        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);

    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age,other.age);
    }
}
