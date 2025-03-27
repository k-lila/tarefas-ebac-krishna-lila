package classes;

public abstract class Pessoa {
    private String nome;
    protected String identificacao;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void mostrarDados(String tipo) {
        System.out.println(" Nome: " + nome);
        System.out.println(String.format(" Identificação (%s): ", tipo) + this.identificacao);
    }

    public abstract void identificar(String id);
}
