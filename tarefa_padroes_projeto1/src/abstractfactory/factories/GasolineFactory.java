package abstractfactory.factories;

import abstractfactory.AbstractCar;
import abstractfactory.AbstractFactory;
import abstractfactory.cars.GasCar;

public class GasolineFactory extends AbstractFactory {
    @Override
    public AbstractCar createHatch() {
        return new GasCar(92, "Hach");
    };
    public AbstractCar createSUV() {
        return new GasCar(177, "SUV");
    };
    public AbstractCar createSport() {
        return new GasCar(201, "Sport");
    };

}
