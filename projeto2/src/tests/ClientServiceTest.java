package tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dao.IClientDAO;
import main.domain.Client;
import main.exceptions.PrimaryKeyNotFound;
import main.services.ClientService;
import main.services.IClientService;
import tests.dao.ClientDAOMock;

public class ClientServiceTest {

    private IClientService clientService;
    private Long cpfTest;

    public ClientServiceTest() {
        IClientDAO dao = new ClientDAOMock();
        clientService = new ClientService(dao);
        this.cpfTest = 12345678900l;
    }

    @BeforeEach
    public void init() throws PrimaryKeyNotFound {
        Client client = new Client(this.cpfTest);
        client.setNome("Gerasda RAsdas");
        client.setEndereco("Rua asdasda");
        client.setNumero(123);
        client.setEstado("RR");
        client.setCidade("Ssads Ased");
        client.setTelefone(99999999l);
        clientService.register(client);
    }

    @Test
    public void searchClient() throws PrimaryKeyNotFound {
        Client clienteConsultado = clientService.search(this.cpfTest);
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void createClient() throws PrimaryKeyNotFound {
        Long novoCPF = 1234l;
        Client novo_cliente = new Client(novoCPF);
        this.clientService.register(novo_cliente);
        Client retorno = this.clientService.search(novoCPF);
        Assert.assertNotNull(retorno);
    }

    @Test
    public void deleteClient() throws PrimaryKeyNotFound {
        Long deleteCPF = 32123l;
        Client novo_cliente = new Client(deleteCPF);
        this.clientService.register(novo_cliente);
        this.clientService.delete(deleteCPF);
        Client clientNull = this.clientService.search(deleteCPF);
        Assert.assertNull(clientNull);
    }

    @Test
    public void updateClient() throws PrimaryKeyNotFound {
        Client altClient = new Client(cpfTest);
        altClient.setNome("0");
        altClient.setEndereco("0");
        altClient.setNumero(0);
        altClient.setEstado("0");
        altClient.setCidade("0");
        altClient.setTelefone(0l);
        this.clientService.update(altClient);
        Client modifiedClient = this.clientService.search(cpfTest);
        Assert.assertTrue(modifiedClient.getNome().equals("0"));
        Assert.assertTrue(modifiedClient.getNumero().equals(0));
        Assert.assertTrue(modifiedClient.getEstado().equals("0"));
        Assert.assertTrue(modifiedClient.getCidade().equals("0"));
        Assert.assertTrue(modifiedClient.getTelefone().equals(0l));
    }

    @Test
    public void allClients() throws PrimaryKeyNotFound{
        for (Integer i = 0; i < 10; i++) {
            Client newClient = new Client(Long.valueOf(i));
            this.clientService.register(newClient);
        }
        Collection<Client> all = this.clientService.all();
        Assert.assertEquals(all.size(), 11);
    }
}
