import abstractfactory.AbstractCar;
import abstractfactory.AbstractFactory;
import abstractfactory.Customer;
import abstractfactory.factories.ElectricFactory;
import abstractfactory.factories.GasolineFactory;

public class App {

    private static AbstractFactory getFactory(Customer cliente) {
        if (cliente.getCarFuel().equals("Electric")) {
            return new ElectricFactory();
        } else {
            return new GasolineFactory();
        }
    }

    public static void main(String[] args) throws Exception {
        AbstractFactory factory;
        Customer[] clientes = {
            new Customer("Gasoline", "SUV"),
            new Customer("Gasoline", "Sport"),
            new Customer("Electric", "Hatch"),
            new Customer("Electric", "SUV"),
            new Customer("Gasoline", "Sport")
        };
        System.out.println();
        for (Customer cliente : clientes) {
            factory = getFactory(cliente);
            AbstractCar clientCar = factory.deliveryCar(cliente.getCatType());
            System.out.println(clientCar.carInfo());
        }
    }
}
