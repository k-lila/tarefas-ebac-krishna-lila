package main.services.generics;

import java.io.Serializable;
import java.util.Collection;

import main.dao.Persistent;
import main.exceptions.PrimaryKeyNotFound;

public interface IGenericService <T extends Persistent, E extends Serializable> {
    public void register(T entity) throws PrimaryKeyNotFound;
    public T search(E valor) throws PrimaryKeyNotFound;
    public void delete(E valor) throws PrimaryKeyNotFound;
    public void update(T entity) throws PrimaryKeyNotFound;
    public Collection<T> all();
}
