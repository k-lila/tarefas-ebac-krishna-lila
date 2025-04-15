package generics.cars;

import generics.AbstractCar;

public class Charger extends AbstractCar {
    public Charger() {
        super("Charger", "Dodge", 670d, 293.47);
    }
    protected String serialNumber() {
        Double randNum = Math.random() * 10000000;
        String serial = String.format("%d", randNum.intValue());
        return serial;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    } 
}
