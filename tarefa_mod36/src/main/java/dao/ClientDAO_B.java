package dao;

import dao.generic.GenericDAO;
import domain.Client;

public class ClientDAO_B extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO_B() {
        super(Client.class, "crud_B");
    }
}
