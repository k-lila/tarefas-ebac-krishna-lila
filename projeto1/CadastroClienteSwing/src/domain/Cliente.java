package domain;
import java.util.Objects;


public class Cliente {

    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    public Cliente(
        String nome,
        Long cpf,
        Long tel,
        String end,
        Integer numero,
        String cidade,
        String estado
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.end = end;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado; 
    }

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Long getCpf() { return this.cpf; }
    public void setCpf(Long cpf) { this.cpf = cpf; }

    public Long getTel() { return this.tel; }
    public void setTel(Long tel) { this.tel = tel; }

    public String getEnd() { return this.end; }
    public void setEnd(String end) { this.end = end; }

    public Integer getNumero() { return this.numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getCidade() { return this.cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return this.estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        String string = String.format("Cliente {nome: %s, cpf: %s}", nome, cpf);
        return string;
    }

    public String getInfo() {
        return String.format("Nome: %s\nCPF: %s\nTelefone: %s\nEndereço: %s, %d\nCidade: %s\nEstado: %s",
            nome, cpf, tel, end, numero, cidade, estado);
    }

}
