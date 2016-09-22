package problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeedRacing {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Car> cars = new ArrayList<>();
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] data = reader.readLine().split("\\s+");
                String model = data[0];
                double fuelAmount = Double.parseDouble(data[1]);
                double fuelCostFor1km = Double.parseDouble(data[2]);
                Car car = new Car(model, fuelAmount, fuelCostFor1km);
                cars.add(car);
            }

            while (true){

                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                String currentModel = params[1];
                int currentDistance = Integer.parseInt(params[2]);
                Car currentCar = cars.stream().filter(car -> car.getModel().equals(currentModel)).findFirst().get();
                if (currentCar == null){
                    throw new IllegalArgumentException("No car found");
                }else {
                    currentCar.moveCar(currentDistance);
                }

            }

            for (Car car : cars) {
                System.out.println(car.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int amountOfKm;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
    }

    public String getModel() {
        return model;
    }

    public void moveCar(int kilometers) {

        int currentKm = (int) (this.fuelAmount / this.fuelCostFor1km);
        if (currentKm < kilometers) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -= kilometers * fuelCostFor1km;
            this.amountOfKm += kilometers;
        }

    }

    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.amountOfKm);
    }
}
