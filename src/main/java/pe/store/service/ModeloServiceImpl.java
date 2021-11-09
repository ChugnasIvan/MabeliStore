package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Modelo;
import pe.store.repository.ModeloRepository;

import java.util.Collection;

@Service
public class ModeloServiceImpl implements GenericService<Modelo,Integer> {

    @Autowired
    private ModeloRepository repository;

    @Override
    public void insert(Modelo obj) {
        repository.save(obj);
    }

    @Override
    public void update(Modelo obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Modelo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Modelo> findAll() {
        return (Collection<Modelo>) repository.findAll();
    }
}
