package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Client;

public class ClientDAO extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public void updateData(Client entity, Client oldEntity) {
		oldEntity.setCidade(entity.getCidade());
		oldEntity.setCPF(entity.getCPF());
		oldEntity.setEndereco(entity.getEndereco());
		oldEntity.setEstado(entity.getEstado());
		oldEntity.setNome(entity.getNome());
		oldEntity.setNumero(entity.getNumero());
		oldEntity.setTelefone(entity.getTelefone());        
    }
}
