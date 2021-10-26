package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.repository.AreaRepository;

import java.util.Collection;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private AreaRepository repository;

    @Override
    public void insert(Area area) {
        repository.save(area);
    }

    @Override
    public void update(Area area) {
        repository.save(area);
    }

    @Override
    public void delete(Integer areaId) {
        repository.deleteById(areaId);
    }

    @Override
    public Area findById(Integer areaId) {
        return repository.findById(areaId).orElse(null);
    }

    @Override
    public Collection<Area> findAll() {
        return (Collection<Area>) repository.findAll();
    }

    @Override
    public Collection<Area> findByName(String name) {
        //return repository.buscarPorNombre(name);
        return null;
    }
}
