package dao;

import dao.generic.GenericDAO;
import domain.Client;

public class ClientDAO_A extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO_A() {
        super(Client.class, "crud_A");
    }
}
