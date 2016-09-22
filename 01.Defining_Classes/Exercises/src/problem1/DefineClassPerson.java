package problem1;

import java.lang.reflect.Field;

public class DefineClassPerson {

    public static void main(String[] args) {

        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}

class Person{
    private String name;
    private int age;
}
