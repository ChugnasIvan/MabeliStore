package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Producto;
import pe.store.repository.ProductoRepository;

import java.util.Collection;

@Service
public class ProductoServiceImpl implements GenericService<Producto,Integer>{

    @Autowired
    private ProductoRepository repository;

    @Override
    public void insert(Producto obj) {
        repository.save(obj);
    }

    @Override
    public void update(Producto obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Producto findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Producto> findAll() {
        return (Collection<Producto>) repository.findAll();
    }
}

