package problem1.models;

import java.math.BigDecimal;

public abstract class Vehicle {

    private BigDecimal fuelQuantity;
    private BigDecimal fuelConsumptionPerKM;
    private BigDecimal tankCapacity;


    protected Vehicle(BigDecimal fuelQuantity, BigDecimal fuelConsumptionPerKM, BigDecimal tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
        this.tankCapacity = tankCapacity;
    }

    protected BigDecimal getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(BigDecimal fuelQuantity) {
        if (fuelQuantity.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected BigDecimal getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }

    public BigDecimal getTankCapacity() {
        return tankCapacity;
    }

    public abstract void refuel(BigDecimal quantity);

    public abstract void drive(BigDecimal km);

    @Override
    public String toString() {
        BigDecimal roundOff = this.fuelQuantity.setScale(2, BigDecimal.ROUND_HALF_UP);
        return String.format("%s: %s", this.getClass().getSimpleName(), roundOff);
    }
}
