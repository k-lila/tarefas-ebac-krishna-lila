package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.dao.jdbc.ConnectionFactory;
import main.domain.Cliente;

public class ClienteDAO implements IClienteDAO{

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTES (ID, CPF, NOME) VALUES (nextval('SQ_CLIENTES'),?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getNome());
            return statement.executeUpdate();
        } catch(Exception exception) {
            throw exception;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Cliente consultar(String cpf) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTES WHERE CPF = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            if (result.next()) {
                cliente = new Cliente();
                cliente.setId(result.getLong("ID"));
                cliente.setCpf(result.getString("CPF"));
                cliente.setNome(result.getString("NOME"));
            }
            return cliente;
        } catch(Exception exception) {
            throw exception;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer editar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_CLIENTES SET NOME = ? WHERE ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setLong(2, cliente.getId());
            return statement.executeUpdate();
        } catch(Exception exception) {
            throw exception;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(String cpf) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTES WHERE CPF = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            return statement.executeUpdate();
            } catch(Exception exception) {
            throw exception;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Cliente> listarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTES";
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(result.getLong("ID"));
                cliente.setCpf(result.getString("CPF"));
                cliente.setNome(result.getString("NOME"));
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch(Exception exception) {
            throw exception;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
