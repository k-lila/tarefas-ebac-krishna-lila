package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import main.dao.jdbc.ConnectionFactory;


public class TesteIntegracaoConnectionFactory {
    @Test
    public void conexaoDeveSerValida() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection);
        assertFalse(connection.isClosed());
        connection.close();
        assertTrue(connection.isClosed());
    }
}
