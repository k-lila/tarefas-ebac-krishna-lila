package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.dao.jdbc.ConnectionFactory;
import main.domain.Produto;

public class ProdutoDAO implements IProductDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTOS (ID, CODIGO, NOME, PRECO, QUANTIDADE) VALUES (nextval('SQ_PRODUTOS'),?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, produto.getCodigo());
            statement.setString(2, produto.getNome());
            statement.setDouble(3, produto.getPreco());
            statement.setLong(4, produto.getQuantidade());
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
    public Produto consultar(Long codigo) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTOS WHERE CODIGO = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, codigo);
            result = statement.executeQuery();
            if (result.next()) {
                produto = new Produto();
                produto.setId(result.getLong("ID"));
                produto.setCodigo(result.getLong("CODIGO"));
                produto.setNome(result.getString("NOME"));
                produto.setPreco(result.getDouble("PRECO"));
                produto.setQuantidade(result.getLong("QUANTIDADE"));
            }
            return produto;
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
    public Integer editar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTOS SET NOME = ?, PRECO = ?, QUANTIDADE = ? WHERE CODIGO = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setLong(3, produto.getQuantidade());
            statement.setLong(4, produto.getCodigo());
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
    public Integer excluir(Long codigo) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTOS WHERE CODIGO = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, codigo);
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
    public List<Produto> listarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Produto> listaProdutos = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTOS";
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                Produto p = new Produto();
                p.setId(result.getLong("ID"));
                p.setCodigo(result.getLong("CODIGO"));
                p.setNome(result.getString("NOME"));
                p.setPreco(result.getDouble("PRECO"));
                p.setQuantidade(result.getLong("QUANTIDADE"));
                listaProdutos.add(p);
            }
            return listaProdutos;
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
