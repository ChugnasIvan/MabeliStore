package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Proveedor;
import pe.store.repository.ProveedorRepository;

import java.util.Collection;

@Service
public class ProveedorServiceImpl implements GenericService<Proveedor,Integer>{

    @Autowired
    private ProveedorRepository repository;

    @Override
    public void insert(Proveedor obj) {
        repository.save(obj);
    }

    @Override
    public void update(Proveedor obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Proveedor findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Proveedor> findAll() {
        return (Collection<Proveedor>) repository.findAll();
    }
}
