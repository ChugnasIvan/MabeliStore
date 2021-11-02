package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Cargo;
import pe.store.model.TipoDocumento;
import pe.store.repository.TipoDocRepository;

import java.util.Collection;

@Service
public class TipoDocServiceImpl implements GenericService<TipoDocumento,Integer> {

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private TipoDocRepository repository;

    @Override
    public void insert(TipoDocumento obj) {
        repository.save(obj);
    }

    @Override
    public void update(TipoDocumento obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public TipoDocumento findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<TipoDocumento> findAll() {
        return (Collection<TipoDocumento>) repository.findAll();
    }

}
