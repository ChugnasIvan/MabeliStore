package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Cargo;
import pe.store.model.Distrito;
import pe.store.repository.DistritoRepository;

import java.util.Collection;

@Service
public class DistritoServiceImpl implements GenericService<Distrito,Integer> {

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private DistritoRepository repository;

    @Override
    public void insert(Distrito obj) {
        repository.save(obj);
    }

    @Override
    public void update(Distrito obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Distrito findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Distrito> findAll() {
        return (Collection<Distrito>) repository.findAll();
    }

}
