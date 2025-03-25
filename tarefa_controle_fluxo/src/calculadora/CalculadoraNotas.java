package calculadora;

public class CalculadoraNotas {
    public Double getMedia(Double[] listaNotas) {
        Double numerador = 0.0;
        for (Double i : listaNotas) {
            numerador += i;
        }
        int denominador = listaNotas.length;
        Double resultado = numerador / denominador;
        int arredondado = (int) (resultado * 100);
        return arredondado / 100.0;
    }

    public String getSituacao(Double notaFinal) {
        return notaFinal >= 7 ? "aprovado" : notaFinal >= 5 ? "recuperação" : "reprovado";
    }

    public void calcular(Double[] listaNotas) {
        Double media = getMedia(listaNotas);
        String situacao = getSituacao(media);
        System.out.println("    Nota final:    " + media);
        System.out.println("    Situação:      " + situacao);
    }
}
