package abstractfactory;

public abstract class AbstractFactory {
    public abstract AbstractCar createHatch();
    public abstract AbstractCar createSUV();
    public abstract AbstractCar createSport();

    public AbstractCar deliveryCar(String order) {
        AbstractCar clientCar;
        switch (order) {
            case "Hatch":
                clientCar = createHatch();
                break;
            case "SUV":
                clientCar = createSUV();
                break;
            case "Sport":
                clientCar = createSport();
                break;
            default:
                throw new IllegalArgumentException("\n\nTipo de carro inválido\n");
        }
        clientCar.fillUp();
        return clientCar;
    }
}
