package abstractfactory.cars;

import abstractfactory.AbstractCar;

public class GasCar extends AbstractCar {
    public GasCar(Integer enginePower, String carType) {
        super("Gasoline", enginePower, carType);
    }

    @Override
    public void fillUp() {
        this.fuelLvl = 100.0;
    }

    @Override
    public void start() {
        if (this.fuelLvl > 1) {
            this.engine = true;
        }
    }

    @Override 
    public void stop() {
        if (this.engine) {this.engine = false;}
    }

    @Override
    public String carInfo() {
        String info = String.format("===== Gasolina =====\n Tipo: %s\n HP: %s\n tanque: %s\n", this.carType, this.enginePower, this.fuelLvl);
        return info;
    }
}
