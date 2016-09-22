package problem1.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(BigDecimal fuelQuantity, BigDecimal fuelConsumptionPerKM, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKM, tankCapacity);
    }

    @Override
    public void refuel(BigDecimal quantity) {
        BigDecimal newQuantity = super.getFuelQuantity().add(quantity);
        if (newQuantity.compareTo(super.getTankCapacity()) > 0) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(newQuantity);
    }

    @Override
    public void drive(BigDecimal km) {
        BigDecimal fuelConsumption = super.getFuelConsumptionPerKM().add(new BigDecimal("1.4"));
        BigDecimal necesseryFuel = fuelConsumption.multiply(km);
        calculate(necesseryFuel, km);

    }

    public void driveEmpty(BigDecimal km){
        BigDecimal necesseryFuel = super.getFuelConsumptionPerKM().multiply(km);
        calculate(necesseryFuel, km);
    }


    private void calculate(BigDecimal necesseryFuel, BigDecimal km){
        if (super.getFuelQuantity().compareTo(necesseryFuel) > 0) {
            DecimalFormat df = new DecimalFormat("0.######");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(km));
            super.setFuelQuantity(super.getFuelQuantity().subtract(necesseryFuel));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }
}
