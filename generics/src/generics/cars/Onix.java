package generics.cars;

import generics.AbstractCar;

public class Onix extends AbstractCar {
    public Onix() {
        super("Onix", "Chevrolet", 116d, 16.8);
    }
    protected String serialNumber() {
        Double randNum = Math.random() * 10000;
        String serial = String.format("%s%d%s", this.model, randNum.intValue(), this.brand.substring(0, 4));
        return serial;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    } 
}
