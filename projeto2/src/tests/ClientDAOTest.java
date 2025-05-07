package tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;


import main.dao.ClientDAO;
import main.dao.IClientDAO;
import main.domain.Client;
import main.exceptions.PrimaryKeyNotFound;

public class ClientDAOTest {
    private IClientDAO clientDAO;
    String nome;
    Long cpf;
    String cidade;
    String end;
    String estado;
    Integer num;
    Long tel;

    public ClientDAOTest() {
        this.clientDAO = new ClientDAO();
        this.nome = "teste";
        this.cpf = 1l;
        this.cidade = "teste";
        this.end = "teste";
        this.estado = "teste";
        this.num = 1;
        this.tel = 1l;
    }

    @Test
    public void createEntryTest() throws PrimaryKeyNotFound {
        for (int i = 0; i < 10; i++) {
            Client client = new Client(cpf * i);
            this.clientDAO.register(client);
        }
        Integer finalNum = this.clientDAO.all().size();
        Assert.assertEquals(finalNum, Integer.valueOf(10));
    }

    @Test
    public void searchEntryTest() throws PrimaryKeyNotFound {
        Client client = new Client(cpf);
        this.clientDAO.register(client);
        Client sameClient = this.clientDAO.search(cpf);
        Assert.assertNotNull(sameClient);
    }

    @Test
    public void deleteEntryTest() throws PrimaryKeyNotFound {
        for (int i = 0; i < 10; i++) {
            Client client = new Client(cpf * i);
            this.clientDAO.register(client);
        }
        Assert.assertEquals(this.clientDAO.all().size(), 10);
        for (int i = 0; i < 10; i++) {
            this.clientDAO.delete(cpf * i);
        }
        Assert.assertEquals(this.clientDAO.all().size(), 0);
    }

    @Test
    public void updateEntryTest() throws PrimaryKeyNotFound {
        Client client = new Client(cpf);
        this.clientDAO.register(client);
        Client client2 = new Client(cpf);
        client2.setNome(this.nome);
        client2.setEndereco(this.end);
        client2.setNumero(this.num);
        client2.setEstado(this.estado);
        client2.setCidade(this.cidade);
        client2.setTelefone(this.tel);
        this.clientDAO.update(client2);
        Client testClient = this.clientDAO.search(cpf);
        Assert.assertNotNull(testClient.getNome());
        Assert.assertNotNull(testClient.getEndereco());
        Assert.assertNotNull(testClient.getNumero());
        Assert.assertNotNull(testClient.getEstado());
        Assert.assertNotNull(testClient.getCidade());
        Assert.assertNotNull(testClient.getTelefone());
    }

    @Test
    public void searchAllTest() throws PrimaryKeyNotFound {
        for (int i = 0; i < 10; i++) {
            Client client = new Client(cpf * i);
            this.clientDAO.register(client);
        }
        Collection<Client> all = this.clientDAO.all();
        Assert.assertEquals(all.size(), 10);
    }
}
