package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Marca;
import pe.store.repository.MarcaRepository;

import java.util.Collection;

@Service
public class MarcaServiceImpl implements GenericService<Marca,Integer>{

    @Autowired
    private MarcaRepository repository;

    @Override
    public void insert(Marca obj) {
        repository.save(obj);
    }

    @Override
    public void update(Marca obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Marca findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Marca> findAll() {
        return (Collection<Marca>) repository.findAll();
    }
}
