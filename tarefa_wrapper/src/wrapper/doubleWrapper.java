package wrapper;

public class doubleWrapper {
    private double primitive;
    private Double wrapped;
    public doubleWrapper(double doubleToWrap) {
        this.primitive = doubleToWrap;
        this.wrapped = (Double) doubleToWrap;
    }
    public void showInfo() {
        System.out.println("# primitivo: " + this.primitive);
        System.out.println("# wrapper: " + this.wrapped + " | " + this.wrapped.getClass().getSimpleName());
    }
}
