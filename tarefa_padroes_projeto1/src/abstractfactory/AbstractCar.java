package abstractfactory;

public abstract class AbstractCar {
    protected String engineType;
    protected Integer enginePower;
    protected String carType;
    protected Double fuelLvl;
    protected Boolean engine;

    public AbstractCar(
        String engineType,
        Integer enginePower,
        String carType
    ) {
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.carType = carType;
        this.fuelLvl = 0.0;
        this.engine = false;
    }

    public abstract void start();
    public abstract void stop();
    public abstract void fillUp();
    public abstract String carInfo();
}

