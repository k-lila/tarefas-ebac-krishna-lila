package main.domain;

import main.annotations.PrimaryKey;
import main.dao.Persistent;

public class Client implements Persistent {
    @PrimaryKey("getCPF")
    private Long cpf;
    private String nome;
    private Long telefone;
    private String endereco;
    private String estado;
    private String cidade;
    private Integer numero;

    public Client(Long cpf) {
        this.cpf = cpf;
    }

    public void setCPF(Long cpf) { this.cpf = cpf; }
    public Long getCPF() { return this.cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getEndereco() { return this.endereco; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getEstado() { return this.estado; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getCidade() { return this.cidade; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public Integer getNumero() { return this.numero; }
    public void setTelefone(Long telefone) { this.telefone = telefone; }
    public Long getTelefone() { return this.telefone; }
    @Override
    public String toString() {
        return "Client [cpf=" + cpf + ", nome=" + nome + "]";
    }
}
