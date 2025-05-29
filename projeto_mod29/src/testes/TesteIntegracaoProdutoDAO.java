package testes;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import main.dao.IProductDAO;
import main.dao.ProdutoDAO;
import main.domain.Produto;

public class TesteIntegracaoProdutoDAO {

    private IProductDAO dao;
    private Produto produtoTeste;
    private Long codigoTeste;
    private String nomeProduto;
    private Double precoTeste;
    private Long quantidadeTeste;

    public TesteIntegracaoProdutoDAO() {
        dao = new ProdutoDAO();
        codigoTeste = 1l;
        nomeProduto = "Nome Produto";
        precoTeste = 1.99;
        quantidadeTeste = 5l;
        produtoTeste = new Produto();
        produtoTeste.setCodigo(codigoTeste);
        produtoTeste.setNome(nomeProduto);
        produtoTeste.setPreco(precoTeste);
        produtoTeste.setQuantidade(quantidadeTeste);        
    }

    @AfterEach
    public void setup() throws Exception{
        dao.excluir(codigoTeste);
    }

    @Test
    public void testeCadastrar() throws Exception {
        Integer result = dao.cadastrar(produtoTeste);
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void testeConsultar() throws Exception {
        dao.cadastrar(produtoTeste);
        Produto consultado = dao.consultar(codigoTeste);
        Assert.assertNotNull(consultado);
    }

    @Test
    public void testeEditar() throws Exception {
        dao.cadastrar(produtoTeste);
        Produto produtoAntigo = dao.consultar(codigoTeste);
        Produto produtoModificado = produtoTeste;
        produtoModificado.setId(produtoAntigo.getId());
        produtoModificado.setNome("Nome Modificado");
        produtoModificado.setPreco(2.50);
        produtoModificado.setQuantidade(1l);
        Integer result = dao.editar(produtoModificado);
        Assert.assertEquals(1, result.intValue());
        Produto novoProduto = dao.consultar(codigoTeste);
        Assert.assertFalse(produtoAntigo.getNome().equals(novoProduto.getNome()));
        Assert.assertFalse(produtoAntigo.getPreco().equals(novoProduto.getPreco()));
        Assert.assertFalse(produtoAntigo.getQuantidade().equals(novoProduto.getQuantidade()));
    }

    @Test
    public void testeExcluir() throws Exception {
        dao.cadastrar(produtoTeste);
        Produto produto = dao.consultar(codigoTeste);
        Assert.assertNotNull(produto);
        dao.excluir(codigoTeste);
        produto = dao.consultar(codigoTeste);
        Assert.assertNull(produto);
    }

    @Test
    public void testeListarTodos() throws Exception {
        for (int i = 0; i < 10; i++) {
            Produto produto = new Produto();
            produto.setCodigo(Long.valueOf(i));
            produto.setNome(String.format("nome_produto_%d", i));
            produto.setPreco(precoTeste * i);
            produto.setQuantidade(Long.valueOf(i));
            dao.cadastrar(produto);
        }
        List<Produto> todosProdutos = dao.listarTodos();
        Assert.assertEquals(10, todosProdutos.size());
        for (int i = 0; i < 10; i++) {
            dao.excluir(Long.valueOf(i));
        }
        todosProdutos = dao.listarTodos();
        Assert.assertEquals(0, todosProdutos.size());
    }
}
