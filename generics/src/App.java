import generics.AbstractCar;
import generics.GenericClass;
import generics.cars.Charger;
import generics.cars.Onix;
import generics.cars.Pulse;

public class App {
    public static void main(String[] args) throws Exception {
        GenericClass<AbstractCar> cars = new GenericClass<>();
        addOneOfEach(cars);
        addOneOfEach(cars);
        cars.show();
    }

    public static void addOneOfEach(GenericClass<AbstractCar> generic) {
        generic.newCar(new Onix());
        generic.newCar(new Pulse());
        generic.newCar(new Charger());
    }
}
