package problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OldestFamilyMember {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int count = Integer.parseInt(reader.readLine());
            Family family = new Family();
            for (int i = 0; i < count; i++) {

                String[] input = reader.readLine().split("\\s+");
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                Person person = new Person(name,age);
                family.addFamilyMember(person);

            }

            System.out.println(family.getOldestMember());

            Method getOldestMethod = Family.class.getMethod("getOldestMember");
            Method addMemberMethod = Family.class.getMethod("addFamilyMember", Person.class);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Family{
    private List<Person> family;

    public Family() {
        this.family = new ArrayList<>();
    }

    public void addFamilyMember(Person person){
        this.family.add(person);
    }

    public Person getOldestMember(){
       return this.family.stream().sorted((p1,p2) -> Integer.compare(p2.getAge(),p1.getAge())).findFirst().get();
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
