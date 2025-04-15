package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T extends AbstractCar> {
    private List<AbstractCar> cars;
    public GenericClass() {
        this.cars = new ArrayList<AbstractCar>();
    }

    public void newCar(AbstractCar car) {
        cars.add(car);
    }

    public void show() {
        for (AbstractCar car : this.cars) {
            System.out.println("=".repeat(25));
            System.out.println(car.toString());
        }
        System.out.println("=".repeat(25));
    }
}
