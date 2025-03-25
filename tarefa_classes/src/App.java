import klila.cafeteira.Cafeteira;

public class App {
    public static void main(String[] args) throws Exception {
        Cafeteira cafeteira = new Cafeteira();
        cafeteira.setReservatorioAgua(1);
        cafeteira.setReservatorioCafe(1);
        cafeteira.setOnOff(true);
        cafeteira.fazerCafe();
    }
}

