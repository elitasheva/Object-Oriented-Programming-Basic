package problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RawData {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Car> cars = new ArrayList<>();
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] input = reader.readLine().split("\\s+");
                Car car = new Car(input);
                cars.add(car);
            }

            String lastCommand = reader.readLine();

            if (lastCommand.equals("fragile")) {

                cars.stream().filter(car -> car.getCargo().getType().compareTo(CargoType.FRAGILE) == 0).forEach(car -> {
                    List<Tire> tires = Arrays.asList(car.getTires())
                            .stream()
                            .filter(t -> t.getPressure() < 1)
                            .collect(Collectors.toList());
                    if (tires.size() > 0){
                        System.out.println(car.getModel());
                    }
                });
            }

            if (lastCommand.equals("flamable")) {

                cars.stream().filter(car -> car.getCargo().getType().compareTo(CargoType.FLAMABLE) == 0).forEach(car -> {
                    if (car.getEngine().getPower() > 250){
                        System.out.println(car.getModel());
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String[] data) {
        this.model = data[0];
        this.engine = getEngine(data[1], data[2]);
        this.cargo = getCargo(data[3], data[4]);
        this.tires = getTires(data);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    private Cargo getCargo(String weightInput, String typeInput) {

        int weight = Integer.parseInt(weightInput);

        if (typeInput.equals("fragile")) {
            return new Cargo(weight, CargoType.FRAGILE);
        } else {
            return new Cargo(weight, CargoType.FLAMABLE);
        }
    }

    private Engine getEngine(String speedInpit, String powerInput) {

        int speed = Integer.parseInt(speedInpit);
        int power = Integer.parseInt(powerInput);
        return new Engine(speed, power);
    }

    private Tire[] getTires(String[] data) {

        List<Tire> tires = new ArrayList<>();
        for (int i = 5; i < data.length - 1; i += 2) {

            double pressure = Double.parseDouble(data[i]);
            int age = Integer.parseInt(data[i + 1]);
            Tire tire = new Tire(pressure, age);
            tires.add(tire);
        }

        return tires.toArray(new Tire[4]);
    }
}

class Engine {

    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }
}

class Cargo {

    private int weight;
    private CargoType type;

    public Cargo(int weight, CargoType type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public CargoType getType() {
        return type;
    }
}

class Tire {

    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public int getAge() {
        return age;
    }
}

enum CargoType {

    FRAGILE,
    FLAMABLE
}