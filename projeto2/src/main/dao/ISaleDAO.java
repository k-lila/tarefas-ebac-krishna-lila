package main.dao;

import main.dao.generics.IGenericDAO;
import main.domain.Sale;
import main.exceptions.PrimaryKeyNotFound;

public interface ISaleDAO extends IGenericDAO<Sale, String> {
    public void closeDeal(Sale sale) throws PrimaryKeyNotFound;
}
