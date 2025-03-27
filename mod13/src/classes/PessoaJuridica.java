package classes;

public class PessoaJuridica extends Pessoa {
    private String localizacao;
    
    public PessoaJuridica(String nome) {
        super(nome);
    }

    @Override
    public void identificar(String id) {
        this.identificacao = id;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

}