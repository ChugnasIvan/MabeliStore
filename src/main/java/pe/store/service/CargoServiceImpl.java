package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Cargo;
import pe.store.repository.CargoRepository;

import java.util.Collection;

@Service
public class CargoServiceImpl implements GenericService<Cargo,Integer> {

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private CargoRepository repository;

    @Override
    public void insert(Cargo obj) {
        repository.save(obj);
    }

    @Override
    public void update(Cargo obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Cargo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Cargo> findAll() {
        return (Collection<Cargo>) repository.findAll();
    }

}
