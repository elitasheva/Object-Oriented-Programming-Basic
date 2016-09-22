package problem1;

import problem1.models.Child;
import problem1.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String name = reader.readLine();
            Integer age = Integer.valueOf(reader.readLine());

            try {
                Child child = new Child(name,age);
                System.out.println(child);
                String personClassName = Person.class.getSimpleName();
                String childClassName = Person.class.getSimpleName();

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
