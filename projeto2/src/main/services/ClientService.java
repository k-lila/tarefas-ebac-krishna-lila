package main.services;

import java.util.Collection;

import main.dao.IClientDAO;
import main.domain.Client;
import main.exceptions.PrimaryKeyNotFound;
import main.services.generics.GenericService;

public class ClientService extends GenericService<Client, Long> implements IClientService{
    public ClientService(IClientDAO iClientDAO) {
        super(iClientDAO);
    };

    @Override
    public void register(Client entity) throws PrimaryKeyNotFound {
        this.dao.register(entity);
    }

    @Override
    public Client search(Long valor) throws PrimaryKeyNotFound {
        return this.dao.search(valor);
    }

    @Override
    public void delete(Long valor) throws PrimaryKeyNotFound {
        this.dao.delete(valor);
    }

    @Override
    public void update(Client entity) throws PrimaryKeyNotFound {
        this.dao.update(entity);
    }

    @Override
    public Collection<Client> all() {
        return this.dao.all();
    }
}
