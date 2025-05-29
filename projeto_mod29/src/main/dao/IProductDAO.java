package main.dao;

import java.util.List;

import main.domain.Produto;

public interface IProductDAO {
    public Integer cadastrar(Produto produto) throws Exception;
    public Produto consultar(Long codigo) throws Exception;
    public Integer editar(Produto produto) throws Exception;
    public Integer excluir(Long codigo) throws Exception;
    public List<Produto> listarTodos() throws Exception;
}
