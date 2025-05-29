package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;

public class TesteIntegracaoClienteDAO {
    private IClienteDAO dao;
    private String nomeTeste;
    private String cpfTeste;
    private Cliente clienteTeste;

    public TesteIntegracaoClienteDAO() {
        dao = new ClienteDAO();
        nomeTeste = "Nome Teste";
        cpfTeste = "cpfTeste";   
        clienteTeste = new Cliente();
        clienteTeste.setNome(nomeTeste);
        clienteTeste.setCpf(cpfTeste);
    }

    @Before
    public void setup() throws Exception {
        dao.excluir(cpfTeste);
    }

    @Test
    public void testeCadastro() throws Exception {
        Integer retornoCadastro = dao.cadastrar(clienteTeste);
        assertEquals(1, retornoCadastro.intValue());
    }

    @Test
    public void testeConsulta() throws Exception {
        dao.cadastrar(clienteTeste);
        Cliente cliente = dao.consultar(cpfTeste);
        Assert.assertNotNull(cliente);
    }

    @Test
    public void testeEditar() throws Exception {
        dao.cadastrar(clienteTeste);
        Cliente consultado = dao.consultar(cpfTeste);
        Cliente clienteModificado = new Cliente();
        clienteModificado.setId(consultado.getId());
        clienteModificado.setCpf(consultado.getCpf());
        clienteModificado.setNome("Nome Modificado");
        Integer result = dao.editar(clienteModificado);
        assertTrue(result.equals(1));
        Cliente modificado = dao.consultar(cpfTeste);
        assertEquals(modificado.getNome(), "Nome Modificado");
    }

    @Test
    public void testeExcluir() throws Exception {
        dao.cadastrar(clienteTeste);
        Integer result = dao.excluir(cpfTeste);
        assertEquals(1, result.intValue());
        Cliente cliente = dao.consultar(cpfTeste);
        assertNull(cliente);
    }

    @Test
    public void testeListarTodos() throws Exception {
        for (int i = 0; i < 10; i++) {
            Cliente c = new Cliente();
            c.setCpf(String.format("%d", i));
            c.setNome("Nome Todos");
            dao.cadastrar(c);
        }
        List<Cliente> todos = dao.listarTodos();
        assertEquals(10, todos.size());
        for (int i = 0; i < 10; i++) {
            dao.excluir(String.format("%d", i));
        }
        todos = dao.listarTodos();
        assertEquals(0, todos.size());
    }
}
