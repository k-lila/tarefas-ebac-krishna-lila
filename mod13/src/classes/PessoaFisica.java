package classes;

public class PessoaFisica extends Pessoa {
    private String localNascimento;
    
    public PessoaFisica(String nome) {
        super(nome);
    }

    @Override
    public void identificar(String id) {
        this.identificacao = id;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public String getLocalNascimento() {
        return this.localNascimento;
    }

}
