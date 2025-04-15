package generics.cars;

import generics.AbstractCar;

public class Pulse extends AbstractCar {
    public Pulse() {
        super("Pulse", "Fiat", 130d, 20.39);
    }
    protected String serialNumber() {
        Double randNum = Math.random() * 100000;
        String serial = String.format("%s[%d]%s", this.model, randNum.intValue(), this.brand.substring(0, 1));
        return serial;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    } 
}
