package main.dao;

import java.util.List;

import main.domain.Cliente;

public interface IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;
    public Cliente consultar(String cpf) throws Exception;
    public Integer editar(Cliente cliente) throws Exception;
    public Integer excluir(String cpf) throws Exception;
    public List<Cliente> listarTodos() throws Exception;
}
