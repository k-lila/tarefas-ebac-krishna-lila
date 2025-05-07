package main.services.generics;

import java.io.Serializable;
import java.util.Collection;

import main.dao.Persistent;
import main.dao.generics.IGenericDAO;
import main.exceptions.PrimaryKeyNotFound;

public abstract class GenericService<T extends Persistent, E extends Serializable> implements IGenericService<T, E> {
    protected IGenericDAO<T, E> dao;
    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }
    @Override
    public void register(T entity) throws PrimaryKeyNotFound {
        this.dao.register(entity);
    }

    @Override
    public T search(E valor) throws PrimaryKeyNotFound {
        return this.dao.search(valor);
    }

    @Override
    public void delete(E valor) throws PrimaryKeyNotFound {
        this.dao.delete(valor);
    }

    @Override
    public Collection<T> all() {
        return this.dao.all();
    }
}
