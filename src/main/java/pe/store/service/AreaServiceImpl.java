package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.repository.AreaRepository;

import java.util.Collection;

@Service
public class AreaServiceImpl implements GenericService<Area,Integer> {

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private AreaRepository repository;

    @Override
    public void insert(Area obj) {
        repository.save(obj);
    }

    @Override
    public void update(Area obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Area findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Area> findAll() {
        return (Collection<Area>) repository.findAll();
    }

}
