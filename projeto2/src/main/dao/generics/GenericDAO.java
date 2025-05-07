package main.dao.generics;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.lang.reflect.Field;

import main.dao.Persistent;
import main.annotations.PrimaryKey;
import main.exceptions.PrimaryKeyNotFound;

public abstract class GenericDAO<T extends Persistent, E extends Serializable> implements IGenericDAO<T, E> {
    private Singleton singleton;
    public abstract Class<T> getClassType();
    public abstract void updateData(T entity, T oldEntity);
    public GenericDAO() {
        this.singleton = Singleton.getInstance();
    }

    public E getPrimaryKey(T entity) throws PrimaryKeyNotFound {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
                String nomeMetodo = primaryKey.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new PrimaryKeyNotFound("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new PrimaryKeyNotFound(msg);
        }
        return null;
    }

    private LinkedHashMap<E, T> getLinkedHashMap() {
        LinkedHashMap<E, T> innerLinkedHashMap = (LinkedHashMap<E, T>) this.singleton.getSingle().get(getClassType());
        if (innerLinkedHashMap == null) {
            innerLinkedHashMap = new LinkedHashMap<>();
            this.singleton.getSingle().put(getClassType(), innerLinkedHashMap);
        }
        return innerLinkedHashMap;
    }

    @Override
    public void register(T entity) throws PrimaryKeyNotFound {
        LinkedHashMap<E, T> inner = getLinkedHashMap();
        E key = getPrimaryKey(entity);
        if (!inner.containsKey(key)) {
            inner.put(key, entity);
        }
    }

    @Override
    public T search(E value) throws PrimaryKeyNotFound {
        LinkedHashMap<E, T> inner = getLinkedHashMap();
        return inner.get(value);

    }

    @Override
    public void delete(E value) throws PrimaryKeyNotFound {
        LinkedHashMap<E, T> inner = getLinkedHashMap();
        T registered = inner.get(value);
        if (registered != null) {
            inner.remove(value, registered);
        }
    }

    @Override
    public void update(T entity) throws PrimaryKeyNotFound {
        LinkedHashMap<E, T> inner = getLinkedHashMap();
        E key = getPrimaryKey(entity);
        T oldEntity = inner.get(key);
        if (oldEntity != null) {
            updateData(entity, oldEntity);
        }
    }

    @Override
    public Collection<T> all() {
        LinkedHashMap<E, T> inner = getLinkedHashMap();
        return inner.values();
    }

}
