package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Sale;
import main.domain.Sale.Status;
import main.exceptions.PrimaryKeyNotFound;

public class SaleDAO extends GenericDAO<Sale, String> implements ISaleDAO {

    @Override
    public Class<Sale> getClassType() {
        return Sale.class;
    }

    @Override
    public void updateData(Sale entity, Sale oldEntity) {
        oldEntity.setCode(entity.getCode());
        oldEntity.setStatus(entity.getStatus());
    }

    @Override
    public void closeDeal(Sale sale) throws PrimaryKeyNotFound {
        sale.setStatus(Status.CONCLUIDA);
        super.update(sale);
    }
}
