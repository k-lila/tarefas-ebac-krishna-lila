package dao;

import dao.generic.GenericDAO;
import domain.Client;
import exceptions.DAOException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientDAO extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO() {
        super(Client.class);
    }

    @Override
    public Client searchByCPF(String cpf) throws DAOException {
        try {
            String jpql = "SELECT c FROM Client c WHERE c.cpf = :cpf";
            Client client = entityManager
                .createQuery(jpql, Client.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
            return client;
        } catch (Exception e) {
            throw new DAOException("ERRO AO BUSCAR CLIENTE POR CPF", e);
        }
    }
}
