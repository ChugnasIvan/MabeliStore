package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Categoria;
import pe.store.repository.CategoriaRepository;

import java.util.Collection;
@Service
public class CategoriaServiceImpl implements GenericService<Categoria,Integer>{

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void insert(Categoria obj) {
        repository.save(obj);
    }

    @Override
    public void update(Categoria obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Categoria findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Categoria> findAll() {
        return (Collection<Categoria>) repository.findAll();
    }
}
