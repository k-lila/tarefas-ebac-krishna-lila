package abstractfactory;

public class Customer {
    private String carFuel;
    private String carType;
    public Customer(String carFuel, String carType) {
        this.carFuel = carFuel;
        this.carType = carType;
    }

    public String getCarFuel() {
        return this.carFuel;
    }

    public String getCatType() {
        return this.carType;
    }
}
