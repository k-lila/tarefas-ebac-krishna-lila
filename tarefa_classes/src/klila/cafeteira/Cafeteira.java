package klila.cafeteira;


/**
 * Classe que representa uma cafeteira, 
 * é possível adicionar água, café e ligar/desligar.
 * 
 * A classe imprime no console uma xícara de café
 * 
 * Quanto mais água e café, maior a xícara.
 * 
 * @author krishna lila
 * @version 1.0
 */
public class Cafeteira {

    private int reservatorioAgua;
    private int reservatorioCafe;
    private boolean onOff;

    public Cafeteira() {
        this.reservatorioAgua = 0;
        this.reservatorioCafe = 0;
        this.onOff = false;
    }

    public void setReservatorioAgua(int agua) {
        this.reservatorioAgua += agua;
    }

    public void setReservatorioCafe(int cafe) {
        this.reservatorioCafe += cafe;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    /**
     * @param height valor que controla o tamanho do vapor
     */
    public void printSteam(int height) {
        int multiplier = height / 10 <= 1 ? 1 : height / 10;
        int width = (height * 2) + (multiplier * 9);
        String steam =  " -   .   +   .   - ".repeat(multiplier);
        for  (int i = 0; i < height / 1.5; i++) {
            double oscilation = Math.sin(Math.toRadians(i * 50)) + 1;
            int position = (int) Math.round(oscilation * 2) - (steam.length() / 2);
            String space = " ".repeat(position + (width / 2) - multiplier);
            System.out.println(space + steam);
        }
        System.out.println("");
    }

    /**
     * @param height valor que controla o tamanho da xícara
     */
    public void printCup(int height) {
        int radius = (height - (height / 4)) / 2;
        int multiplier = height / 10 <= 1 ? 1 : height / 10;
        int width = (height * 2) + (multiplier * 9);
        String cup = "*".repeat(width);
        for (int i = 0; i < height; i++) {
            String handle = "";
            if (i <= radius * 2) {
                for (int j = radius; j <= 2 * radius; j++) { 
                    double dist = Math.sqrt((i - radius) * (i - radius) + (j - radius) * (j - radius));
                    if (dist > radius - (multiplier * 1.5) && dist < radius + multiplier) {
                        handle += "*"; 
                    } else {
                        handle += " ";
                    }
                } 
                System.out.println(cup + handle);
            }
        }
        for (int i = 0; i <= multiplier; i ++) {
            System.out.println(" ".repeat(i) + cup.substring(i, cup.length() - i));
        }
    }

    /**
     * A máquina precisa estar ligada.
     * É preciso, no mínimo, 1 café e 1 de água.
     */
    public void fazerCafe() {
        if (this.onOff && this.reservatorioAgua >= 1 && this.reservatorioCafe >= 1) {
            int height = reservatorioCafe * reservatorioAgua * 8;
            System.out.println("\nPreparando...\n\n");
            printSteam(height);
            printCup(height);
            System.out.println("\nPronto!\n");
        } else {
            System.out.println("Não é possível fazer café");
        }
    }
}
