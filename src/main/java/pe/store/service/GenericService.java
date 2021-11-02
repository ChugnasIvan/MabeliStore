package pe.store.service;

import pe.store.model.Area;

import java.io.Serializable;
import java.util.Collection;

public interface GenericService<T, ID extends Serializable> {

    public abstract void insert(T obj);

    public abstract void update(T obj);

    public abstract void delete(ID id);

    public abstract T findById(ID id);

    public abstract Collection<T> findAll();

}
