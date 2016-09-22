package problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class CarSalesman {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Engine> engines = new ArrayList<>();
            List<Car> cars = new ArrayList<>();

            int countEng = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countEng; i++) {
                String[] dataEng = reader.readLine().split("\\s+");
                Engine engine = getEngine(dataEng);
                engines.add(engine);
            }

            int countCars = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countCars; i++) {

                String[] dataCar = reader.readLine().split("\\s+");
                Car car = getCar(dataCar, engines);
                cars.add(car);

            }

            for (Car car : cars) {
                System.out.println(car.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Car getCar(String[] dataCar, List<Engine> engines) {

        int count = dataCar.length;
        String engineModel = dataCar[1];
        Engine currentEngine = engines.stream().filter(eng -> eng.getModel().equals(engineModel)).findFirst().get();
        int weight = 0;
        String color = "";
        switch (count) {
            case 2:
                return new Car(dataCar[0], currentEngine);
            case 3:
                Car car = null;
                try {
                    weight = Integer.parseInt(dataCar[2]);
                    car = new Car(dataCar[0], currentEngine, weight);
                } catch (Exception e) {
                    color = dataCar[2];
                    car = new Car(dataCar[0], currentEngine, color);
                }
                return car;
            case 4:
                weight = Integer.parseInt(dataCar[2]);
                return new Car(dataCar[0], currentEngine, weight, dataCar[3]);
            default:
                return null;
        }

    }

    private static Engine getEngine(String[] dataEng) {

        int count = dataEng.length;
        int power = 0;
        int displacement = 0;
        Engine engine = null;
        switch (count) {
            case 2:
                power = Integer.parseInt(dataEng[1]);
                return new Engine(dataEng[0], power);
            case 3:
                power = Integer.parseInt(dataEng[1]);
                try {
                    displacement = Integer.parseInt(dataEng[2]);
                    engine = new Engine(dataEng[0], power, displacement);
                } catch (Exception e) {
                    engine = new Engine(dataEng[0], power, dataEng[2]);
                }
                return engine;
            case 4:
                power = Integer.parseInt(dataEng[1]);
                displacement = Integer.parseInt(dataEng[2]);
                return new Engine(dataEng[0], power, displacement, dataEng[3]);
            default:
                return null;

        }
    }
}

class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, null);

    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, null);

    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);

    }


    public String getModel() {
        return model;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model + ":" + String.format("%n"));
        sb.append("  " + this.engine.getModel() + ":" + String.format("%n"));
        sb.append("    " + this.engine.toString() + String.format("%n"));
        if (this.weight != 0) {
            sb.append("  Weight: " + this.weight + String.format("%n"));
        } else {
            sb.append("  Weight: n/a" + String.format("%n"));
        }

        if (this.color != null) {
            sb.append("  Color: " + this.color + String.format("%n"));
        } else {
            sb.append("  Color: n/a" + String.format("%n"));
        }

        return sb.toString().trim();
    }
}

class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, 0, null);

    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, null);

    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);

    }

    public String getModel() {
        return model;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    Power: " + this.power + String.format("%n"));
        if (this.displacement != 0) {
            sb.append("    Displacement: " + this.displacement + String.format("%n"));
        } else {
            sb.append("    Displacement: n/a" + String.format("%n"));
        }

        if (this.efficiency != null) {
            sb.append("    Efficiency: " + this.efficiency + String.format("%n"));
        } else {
            sb.append("    Efficiency: n/a" + String.format("%n"));
        }

        return sb.toString().trim();
    }
}