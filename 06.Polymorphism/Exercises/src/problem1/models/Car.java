package problem1.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(BigDecimal fuelQuantity, BigDecimal fuelConsumptionPerKM, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKM, tankCapacity);
    }


    @Override
    public void refuel(BigDecimal quantity) {
        BigDecimal newQuantity = super.getFuelQuantity().add(quantity);
        if (newQuantity.compareTo(super.getTankCapacity()) > 0){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(newQuantity);
    }

    @Override
    public void drive(BigDecimal km) {

        BigDecimal fuelConsumption = super.getFuelConsumptionPerKM().add(new BigDecimal("0.9"));
        BigDecimal necesseryFuel = fuelConsumption.multiply(km);
        if (super.getFuelQuantity().compareTo(necesseryFuel) > 0) {
            DecimalFormat df = new DecimalFormat("0.######");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(km));
            super.setFuelQuantity(super.getFuelQuantity().subtract(necesseryFuel));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }


}
