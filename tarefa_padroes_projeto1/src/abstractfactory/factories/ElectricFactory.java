package abstractfactory.factories;

import abstractfactory.AbstractCar;
import abstractfactory.AbstractFactory;
import abstractfactory.cars.ElectricCar;

public class ElectricFactory extends AbstractFactory {
    @Override
    public AbstractCar createHatch() {
        return new ElectricCar(100, "Hach");
    };
    @Override
    public AbstractCar createSUV() {
        return new ElectricCar(150, "SUV");
    };
    @Override
    public AbstractCar createSport() {
        return new ElectricCar(200, "Sport");
    };
}
