package main.domain;

public class Produto {
    private Long id;
    private Long codigo;
    private String nome;
    private Double preco;
    private Long quantidade;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Long getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
