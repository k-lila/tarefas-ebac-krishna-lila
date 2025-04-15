package generics;

public abstract class AbstractCar {
    protected String model;
    protected String brand;
    protected Double power;
    protected Double torque;
    protected String serialNumber;

    public AbstractCar(String model, String brand, Double power, Double torque) {
        this.model = model;
        this.brand = brand;
        this.power = power;
        this.torque = torque;
        this.serialNumber = serialNumber();
    };
    protected abstract String serialNumber();
    @Override
    public String toString() {
        String info = String.format("Modelo: %s\nMarca: %s\nPotência: %.1f CV\nTorque: %.1f kgfm\nn serie: %s", this.model, this.brand, this.power, this.torque, this.serialNumber);
        return info;
    }
}
