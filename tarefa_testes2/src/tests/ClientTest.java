package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dao.Client;
import mocks.ClientMock;

public class ClientTest {
    @Test
    public void ClientTestName() {
        String name = "Teste";
        ClientMock client = new ClientMock(name);
        assertEquals(client.getName(), name);
    }

    @Test
    public void esperadoErroAoCriarCliente() {
        String name = "Teste";
        Client client = new Client(name);
        assertThrows(UnsupportedOperationException.class, client::getName);
    }
}
