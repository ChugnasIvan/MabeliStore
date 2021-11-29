package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Rol;
import pe.store.repository.RolRepository;

import java.util.Collection;

@Service
public class RolServiceImpl implements GenericService<Rol,Integer>{

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private RolRepository repository;

    @Override
    public void insert(Rol obj) {
        repository.save(obj);
    }

    @Override
    public void update(Rol obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Rol findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Rol> findAll() {
        return (Collection<Rol>) repository.findAll();
    }
}
