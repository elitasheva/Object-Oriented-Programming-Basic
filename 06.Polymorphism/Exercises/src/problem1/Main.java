package problem1;

import problem1.models.Bus;
import problem1.models.Car;
import problem1.models.Truck;
import problem1.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] inputCar = reader.readLine().split("\\s+");
            String[] inputTruck = reader.readLine().split("\\s+");
            String[] inputBus = reader.readLine().split("\\s+");
            Vehicle car = new Car(new BigDecimal(inputCar[1]), new BigDecimal(inputCar[2]), new BigDecimal(inputCar[3]));
            Vehicle truck = new Truck(new BigDecimal(inputTruck[1]), new BigDecimal(inputTruck[2]), new BigDecimal(inputTruck[3]));
            Vehicle bus = new Bus(new BigDecimal(inputBus[1]), new BigDecimal(inputBus[2]), new BigDecimal(inputBus[3]));

            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] data = reader.readLine().split("\\s+");
                String command = data[0];
                Vehicle current = null;

                if (data[1].equals("Car")) {
                    current = car;
                } else if(data[1].equals("Truck")){
                    current = truck;
                }else {
                    current = bus;
                }

                BigDecimal thirdParam = new BigDecimal(data[2]);
               try {
                   switch (command) {
                       case "DriveEmpty":
                           Bus a = (Bus)current;
                           a.driveEmpty(thirdParam);
                           break;
                       case "Drive":
                           tryDriveVehicle(current, thirdParam);
                           break;
                       case "Refuel":
                           tryRefuelVehicle(current, thirdParam);
                           break;
                   }
               }catch (IllegalArgumentException ex){
                   System.out.println(ex.getMessage());
               }

            }

            System.out.println(car);
            System.out.println(truck);
            System.out.println(bus);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryRefuelVehicle(Vehicle current, BigDecimal liters) {
        current.refuel(liters);
    }

    private static void tryDriveVehicle(Vehicle current, BigDecimal km) {
        current.drive(km);
    }
}
