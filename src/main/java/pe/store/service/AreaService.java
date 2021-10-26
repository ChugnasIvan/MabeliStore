package pe.store.service;

import pe.store.model.Area;

import java.util.Collection;

public interface AreaService {

    public abstract void insert(Area area);

    public abstract void update(Area area);

    public abstract void delete(Integer areaId);

    public abstract Area findById(Integer areaId);

    public abstract Collection<Area> findAll();

    public abstract Collection<Area> findByName(String name);

}
