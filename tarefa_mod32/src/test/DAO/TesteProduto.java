package test.DAO;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;

public class TesteProduto {
    private IProdutoDAO dao;
    private Produto produtoTeste;
    TesteProduto() {
        dao = new ProdutoDAO();
        produtoTeste = new Produto();
        produtoTeste.setCodigo("teste");
        produtoTeste.setNome("Nome");
        produtoTeste.setPreco(1.99);
    }

    @Test
    public void cadastrarTeste() {
        Boolean cadastro = dao.cadastrar(produtoTeste);
        Assertions.assertTrue(cadastro);
    }
}