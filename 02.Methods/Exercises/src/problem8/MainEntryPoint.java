package problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] initialState = reader.readLine().split("\\s+");
            int speed = Integer.parseInt(initialState[0]);
            double fuel = Double.parseDouble(initialState[1]);
            double fuelEconomy = Double.parseDouble(initialState[2]);
            Car currentCar = new Car(speed, fuel, fuelEconomy);

            while (true) {

                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] params = input.split("\\s+");
                String command = params[0];
                switch (command) {
                    case "Travel":
                        double dist = Double.parseDouble(params[1]);
                        double currentQuantityOfFuel = currentCar.getFuel();
                        double fuelForKm = currentCar.getFuelEconomy()/100;
                        double necessaryFuel = dist*fuelForKm;
                        if (currentQuantityOfFuel >= necessaryFuel){
                            currentCar.setDistance(currentCar.getDistance() + dist);
                            currentCar.setFuel(currentCar.getFuel() - necessaryFuel);
                            double timeTraveled = dist/currentCar.getSpeed();
                            currentCar.setTotalTime(currentCar.getTotalTime() + timeTraveled);
                        }else {
                            double possibleDist = currentCar.getFuel()/fuelForKm;
                            currentCar.setDistance(currentCar.getDistance() + possibleDist);
                            double time = possibleDist/currentCar.getSpeed();
                            currentCar.setTotalTime(currentCar.getTotalTime() + time);
                            currentCar.setFuel(0);

                        }
                        break;
                    case "Refuel":
                        double refuel = Double.parseDouble(params[1]);
                        currentCar.setFuel(currentCar.getFuel() + refuel);
                        break;
                    case "Distance":
                        System.out.printf("Total distance: %.1f kilometers%n", currentCar.getDistance());
                        break;
                    case "Time":
                        int hours = (int)currentCar.getTotalTime();
                        int minutes = (int)(currentCar.getTotalTime()-hours)*60;
                        System.out.printf("Total time: %d hours and %d minutes%n",hours,minutes);
                        break;
                    case "Fuel":
                        System.out.printf("Fuel left: %.1f liters%n", currentCar.getFuel());
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Car {

    private int speed;
    private double fuel;
    private double fuelEconomy;
    private double distance;
    private double totalTime;

    public Car(int speed, double fuel, double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
}
