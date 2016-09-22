package PersonProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class Person{

    //private static final String DEFAULT_NAME = "No name";
    //private static final int DEFAULT_AGE = 1;
    private String name;
    private int age;

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

//    public Person(int age){
//        this(DEFAULT_NAME,age);
//    }

//    public Person(){
//        this(DEFAULT_NAME,DEFAULT_AGE);
//    }


//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public int compareTo(Person other) {
//        return this.getName().compareTo(other.getName());
//    }
}

class MainEntryPoint{
    public static void main(String[] args) {

        //Problem 1
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

//        Person pesho = new Person("Pesho",20);
//        Person gosho = new Person("Gosho",18);
//        Person stamat = new Person("Stamat", 43);

        //Problem 2
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
//
//            Class personClass = Person.class;
//            Constructor emptyConstr = personClass.getDeclaredConstructor();
//            Constructor ageConstr = personClass.getDeclaredConstructor(int.class);
//            Constructor nameAgeConstr = personClass.getConstructor(String.class, int.class);
//
//            String name = reader.readLine();
//            int age = Integer.parseInt(reader.readLine());
//
//            Person basePerson = (Person) emptyConstr.newInstance();
//            Person personWithAge = (Person) ageConstr.newInstance(age);
//            Person personFull = (Person) nameAgeConstr.newInstance(name,age);
//
//            System.out.printf("%s %s%n", basePerson.getName(), basePerson.getAge());
//            System.out.printf("%s %s%n", personWithAge.getName(), personWithAge.getAge());
//            System.out.printf("%s %s%n", personFull.getName(), personFull.getAge());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Problem 3
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
//
//            List<Person> persons = new ArrayList<>();
//            int count = Integer.parseInt(reader.readLine());
//            for (int i = 0; i < count; i++) {
//
//                String[] data = reader.readLine().split("\\s+");
//                String name = data[0];
//                int age = Integer.parseInt(data[1]);
//                Person person = new Person(name,age);
//                persons.add(person);
//            }
//
//            persons
//                    .stream()
//                    .filter(p -> p.getAge() > 30)
//                    .sorted(Person::compareTo)
//                    .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
