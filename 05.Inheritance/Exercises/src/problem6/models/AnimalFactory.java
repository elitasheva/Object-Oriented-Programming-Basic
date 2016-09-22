package problem6.models;

public class AnimalFactory {

    public static Animal create(String type, String name, int age, String gender){
        switch (type){
            case "Cat":
                return new Cat(name, age, gender);
            case "Dog":
                return new Dog(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name,age);
            case "Tomcat":
                return new Tomcat(name,age);
            default:
               throw new IllegalArgumentException("Invalid input!");
        }
    }
}
