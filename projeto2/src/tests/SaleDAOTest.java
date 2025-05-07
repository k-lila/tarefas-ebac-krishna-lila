package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import main.dao.ClientDAO;
import main.dao.IClientDAO;
import main.dao.IProductDAO;
import main.dao.ISaleDAO;
import main.dao.ProductDAO;
import main.dao.SaleDAO;
import main.domain.Client;
import main.domain.Product;
import main.domain.Sale;
import main.exceptions.PrimaryKeyNotFound;
public class SaleDAOTest {

	private ISaleDAO vendaDao;	
	private IClientDAO clienteDao;
	private IProductDAO produtoDao;
	private Client cliente;	
	private Product produto;

	public SaleDAOTest() {
		vendaDao = new SaleDAO();
		clienteDao = new ClientDAO();
		produtoDao = new ProductDAO();
	}

	@Before
	public void init() throws PrimaryKeyNotFound {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}

	@Test
	public void pesquisar() throws PrimaryKeyNotFound {
		Sale venda = criarVenda("A1");
        vendaDao.register(venda);
        Sale retorno = vendaDao.search("A1");
		assertNotNull(retorno);
		Sale vendaConsultada = vendaDao.search(venda.getCode());
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCode(), vendaConsultada.getCode());
	}

	@Test
	public void salvar() throws PrimaryKeyNotFound {
		Sale venda = criarVenda("A2");
        vendaDao.register(venda);
		Sale retorno = vendaDao.search(venda.getCode());
		assertNotNull(retorno);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 

	@Test
	public void cancelarVenda() throws PrimaryKeyNotFound {
		String codigoVenda = "A3";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		venda.setStatus(Sale.Status.CANCELADA);
		vendaDao.update(venda);
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		assertEquals(codigoVenda, vendaConsultada.getCode());
		assertEquals(Sale.Status.CANCELADA, vendaConsultada.getStatus());
	}

	@Test
	public void adicionarMaisProdutosDoMesmo() throws PrimaryKeyNotFound {
		String codigoVenda = "A4";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		vendaConsultada.add(produto, 1);
		assertTrue(venda.getTotalQuantity() == 3);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(30)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 

	@Test
	public void adicionarMaisProdutosDiferentes() throws PrimaryKeyNotFound {
		String codigoVenda = "A5";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		Product prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCode());
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		vendaConsultada.add(prod, 1);
		assertTrue(venda.getTotalQuantity() == 3);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(70)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 

	@Test
	public void removerProduto() throws PrimaryKeyNotFound {
		String codigoVenda = "A7";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		Product prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCode());
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		vendaConsultada.add(prod, 1);
		assertTrue(venda.getTotalQuantity() == 3);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(70)));
		vendaConsultada.remove(prod, 1);
		assertTrue(venda.getTotalQuantity() == 2);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 
	
	@Test
	public void removerApenasUmProduto() throws PrimaryKeyNotFound {
		String codigoVenda = "A8";
		Sale venda = criarVenda(codigoVenda);
        vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		Product prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCode());
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		vendaConsultada.add(prod, 1);
		assertTrue(venda.getTotalQuantity() == 3);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(70)));
		vendaConsultada.remove(prod, 1);
		assertTrue(venda.getTotalQuantity() == 2);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 

	@Test
	public void removerTodosProdutos() throws PrimaryKeyNotFound {
		String codigoVenda = "A9";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		Product prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCode());
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		vendaConsultada.add(prod, 1);
		assertTrue(venda.getTotalQuantity() == 3);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(70)));
		vendaConsultada.removerTodosProdutos();
		assertTrue(venda.getTotalQuantity() == 0);
		assertTrue(venda.getTotalValue().equals(BigDecimal.valueOf(0)));
		assertTrue(venda.getStatus().equals(Sale.Status.INICIADA));
	} 

	@Test
	public void finalizarVenda() throws PrimaryKeyNotFound {
		String codigoVenda = "A10";
		Sale venda = criarVenda(codigoVenda);
        vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());		
		vendaDao.closeDeal(venda);		
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		assertEquals(venda.getCode(), vendaConsultada.getCode());
		assertEquals(venda.getStatus(), vendaConsultada.getStatus());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws PrimaryKeyNotFound {
		String codigoVenda = "A11";
		Sale venda = criarVenda(codigoVenda);
		vendaDao.register(venda);
		Sale retorno = vendaDao.search(codigoVenda);
        assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCode());
		vendaDao.closeDeal(venda);
		Sale vendaConsultada = vendaDao.search(codigoVenda);
		assertEquals(venda.getCode(), vendaConsultada.getCode());
		assertEquals(venda.getStatus(), vendaConsultada.getStatus());
		vendaConsultada.add(this.produto, 1);
	}

	private Product cadastrarProduto(String codigo, BigDecimal valor) throws PrimaryKeyNotFound {
		Product produto = new Product();
		produto.setCode(codigo);
		produto.setDescription("Produto 1");
		produto.setName("Produto 1");
		produto.setValue(valor);
		produtoDao.register(produto);
		return produto;
	}

	private Client cadastrarCliente() throws PrimaryKeyNotFound {
		Client cliente = new Client(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTelefone(1199999999L);
		clienteDao.register(cliente);
		return cliente;
	}

	private Sale criarVenda(String codigo) {
		Sale venda = new Sale();
		venda.setCode(codigo);
		venda.setSaleDate(Instant.now());
		venda.setClient(this.cliente);
		venda.setStatus(Sale.Status.INICIADA);
		venda.add(this.produto, 2);
		return venda;
	}
}
