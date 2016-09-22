package problem1.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(BigDecimal fuelQuantity, BigDecimal fuelConsumptionPerKM, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKM, tankCapacity);
    }


    @Override
    public void refuel(BigDecimal quantity) {
        BigDecimal newQuantity = super.getFuelQuantity().add(quantity.multiply(new BigDecimal("0.95")));
        super.setFuelQuantity(newQuantity);

    }

    @Override
    public void drive(BigDecimal km) {
        BigDecimal fuelConsumption = super.getFuelConsumptionPerKM().add(new BigDecimal("1.6"));
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
