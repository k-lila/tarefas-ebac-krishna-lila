package dao;

import dao.generic.GenericDAO;
import domain.Client;

public class ClientDAO_C extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO_C() {
        super(Client.class, "crud_C");
    }
}
