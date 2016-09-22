package problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodHello {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String name = reader.readLine();
            Person current = new Person(name);
            String greeting = current.sayGreeting();
            System.out.printf(greeting);

            Field[] fields = Class.forName("Person").getDeclaredFields();
            Method[] methods = Class.forName("Person").getDeclaredMethods();
            if (fields.length != 1 || methods.length != 1){
                throw new ClassFormatError();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String sayGreeting(){
        return this.name + " says \"Hello\"!";
    }
}
