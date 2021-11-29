package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Cliente;
import pe.store.repository.ClienteRepository;

import java.util.Collection;

@Service
public class ClienteServiceImpl implements GenericService<Cliente,Integer>{

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private ClienteRepository repository;

    @Override
    public void insert(Cliente obj) {
        repository.save(obj);
    }

    @Override
    public void update(Cliente obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Cliente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Cliente> findAll() {
        return (Collection<Cliente>) repository.findAll();
    }
}
