package test;


import java.time.Instant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dao.ClientDAO_A;
import dao.ClientDAO_B;
import dao.ClientDAO_C;
import dao.IClientDAO;
import domain.Client;
import exceptions.DAOException;

public class ClientDAOTest {

    private IClientDAO clientDAO_A;
    private IClientDAO clientDAO_B;
    private IClientDAO clientDAO_C;

    public Client createClient(String name, Long cpf) {
        Client clientTest = new Client();
        clientTest.setName(name);
        clientTest.setCpf(cpf);
        clientTest.setAddress("endereço");
        clientTest.setNumber(1);
        clientTest.setCity("cidade");
        clientTest.setState("estado");
        clientTest.setFone(9l);
        clientTest.setCreationDate(Instant.now());
        return clientTest;
    }

    public ClientDAOTest() {
        clientDAO_A = new ClientDAO_A();
        clientDAO_B = new ClientDAO_B();
        clientDAO_C = new ClientDAO_C();
    }

    @AfterEach
    public void cleanup() throws DAOException {
        for (Client client : clientDAO_A.showAll()) {
            clientDAO_A.delete(client.getId());
        }
        for (Client client : clientDAO_B.showAll()) {
            clientDAO_B.delete(client.getId());
        }
        for (Client client : clientDAO_C.showAll()) {
            clientDAO_C.delete(client.getId());
        }
    }

    @Test
    public void testCreate() throws DAOException {
        Client client_A = createClient("A", 1l);
        Client client_B = createClient("B", 2l);
        Client client_C = createClient("C", 3l);
        Boolean create_A = clientDAO_A.create(client_A);
        Boolean create_B = clientDAO_B.create(client_B);
        Boolean create_C = clientDAO_C.create(client_C);
        Assertions.assertTrue(create_A);
        Assertions.assertTrue(create_B);
        Assertions.assertTrue(create_C);
        Assertions.assertNotNull(client_A.getId());
        Assertions.assertNotNull(client_B.getId());
        Assertions.assertNotNull(client_C.getId());
    }

    @Test
    public void testRead() throws DAOException {
        clientDAO_A.create(createClient("A", 1l));
        clientDAO_B.create(createClient("B", 2l));
        clientDAO_C.create(createClient("C", 3l));
        Client read_A = clientDAO_A.read(1l);
        Client read_B = clientDAO_B.read(2l);
        Client read_C = clientDAO_C.read(3l);
        Assertions.assertNotNull(read_A);
        Assertions.assertNotNull(read_B);
        Assertions.assertNotNull(read_C);
    }

    @Test
    public void testUpdate() throws DAOException {
        clientDAO_A.create(createClient("A", 1l));
        clientDAO_B.create(createClient("B", 2l));
        clientDAO_C.create(createClient("C", 3l));
        Client client_A = clientDAO_A.read(1l);
        Client client_B = clientDAO_B.read(2l);
        Client client_C = clientDAO_C.read(3l);
        client_A.setName("EditadoA");
        client_B.setName("EditadoB");
        client_C.setName("EditadoC");
        clientDAO_A.update(client_A);
        clientDAO_B.update(client_B);
        clientDAO_C.update(client_C);
        Client updated_A = clientDAO_A.read(1l);
        Client updated_B = clientDAO_B.read(2l);
        Client updated_C = clientDAO_C.read(3l);
        Assertions.assertEquals("EditadoA", updated_A.getName());
        Assertions.assertEquals("EditadoB", updated_B.getName());
        Assertions.assertEquals("EditadoC", updated_C.getName());
    }

    @Test
    public void testDelete() throws DAOException {
        Client client_A = createClient("A", 11l);
        Client client_B = createClient("B", 22l);
        Client client_C = createClient("C", 33l);
        Boolean create_A = clientDAO_A.create(client_A);
        Boolean create_B = clientDAO_B.create(client_B);
        Boolean create_C = clientDAO_C.create(client_C);
        Assertions.assertTrue(create_A);
        Assertions.assertTrue(create_B);
        Assertions.assertTrue(create_C);
        Boolean delete_A = clientDAO_A.delete(client_A.getId());
        Boolean delete_B = clientDAO_B.delete(client_B.getId());
        Boolean delete_C = clientDAO_C.delete(client_C.getId());
        Assertions.assertTrue(delete_A);
        Assertions.assertTrue(delete_B);
        Assertions.assertTrue(delete_C);
    }

    @Test
    public void testShowAll() throws DAOException {
        clientDAO_A.create(createClient("A", 1l));
        clientDAO_B.create(createClient("B", 2l));
        clientDAO_C.create(createClient("C", 3l));
        clientDAO_A.create(createClient("AA", 11l));
        clientDAO_B.create(createClient("BB", 22l));
        clientDAO_C.create(createClient("CC", 33l));
        clientDAO_A.create(createClient("AAA", 111l));
        clientDAO_B.create(createClient("BBB", 222l));
        clientDAO_C.create(createClient("CCC", 333l));
        Integer allA = clientDAO_A.showAll().size();
        Integer allB = clientDAO_B.showAll().size();
        Integer allC = clientDAO_C.showAll().size();
        Assertions.assertEquals(3, allA);
        Assertions.assertEquals(3, allB);
        Assertions.assertEquals(3, allC);
    }
}

