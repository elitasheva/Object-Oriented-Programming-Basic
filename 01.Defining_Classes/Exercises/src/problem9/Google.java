package problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Google {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            LinkedHashMap<String, Person> info = new LinkedHashMap<>();
            while (true) {

                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] data = input.split("\\s+");
                String currentName = data[0];

                if (!info.containsKey(currentName)){
                    info.put(currentName, new Person(currentName));
                }

                Person currentPerson = info.get(currentName);

                String command = data[1];

                switch (command) {
                    case "company":
                        double salary = Double.parseDouble(data[4]);
                        Company company = new Company(data[2], data[3], salary);
                        currentPerson.setCompany(company);
                        break;
                    case "pokemon":
                        Pokemon pokemon = new Pokemon(data[2], data[3]);
                        currentPerson.getPokemons().add(pokemon);
                        break;
                    case "parents":

                        Parent parent = new Parent(data[2], data[3]);
                        currentPerson.getParents().add(parent);
                        break;
                    case "children":

                        Child child = new Child(data[2], data[3]);
                        currentPerson.getChildren().add(child);
                        break;
                    case "car":
                        int speed = Integer.parseInt(data[3]);
                        Car car = new Car(data[2], speed);
                        currentPerson.setCar(car);
                        break;
                }

            }

            String searchedName = reader.readLine();
            System.out.println(info.get(searchedName).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }


    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + String.format("%n"));
        sb.append("Company:" + String.format("%n"));
        if (this.company != null) {
            sb.append(this.company.toString() + String.format("%n"));
        }
        sb.append("Car:" + String.format("%n"));
        if (this.car != null) {
            sb.append(this.car.toString() + String.format("%n"));
        }
        sb.append("Pokemon:" + String.format("%n"));
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon.toString() + String.format("%n"));
        }

        sb.append("Parents:" + String.format("%n"));
        for (Parent parent : parents) {
            sb.append(parent.toString() + String.format("%n"));
        }

        sb.append("Children:" + String.format("%n"));
        for (Child child : children) {
            sb.append(child.toString() + String.format("%n"));
        }
        return sb.toString().trim();
    }
}

class Company {

    private String companyName;
    private String departament;
    private double salary;

    public Company(String companyName, String departament, double salary) {
        this.companyName = companyName;
        this.departament = departament;
        this.salary = salary;
    }


    @Override
    public String toString() {

        return String.format("%s %s %.2f", this.companyName, this.departament, this.salary);
    }
}

class Pokemon {

    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.pokemonName, this.pokemonType);
    }
}

class Parent {

    private String parentName;
    private String parentBhirdday;

    public Parent(String parentName, String parentBhirdday) {
        this.parentName = parentName;
        this.parentBhirdday = parentBhirdday;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.parentName, this.parentBhirdday);
    }
}

class Child {

    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.childName, this.childBirthday);
    }
}

class Car {

    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String toString() {

        return String.format("%s %d", this.carModel, this.carSpeed);
    }
}