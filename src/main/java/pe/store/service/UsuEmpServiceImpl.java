package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.UsuarioEmpleado;
import pe.store.repository.UsuEmpRepository;

import java.util.Collection;

@Service
public class UsuEmpServiceImpl implements GenericService<UsuarioEmpleado,Integer> {

    @Autowired
    private UsuEmpRepository repository;

    @Override
    public void insert(UsuarioEmpleado obj) {
        repository.save(obj);
    }

    @Override
    public void update(UsuarioEmpleado obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UsuarioEmpleado findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<UsuarioEmpleado> findAll() {
        return (Collection<UsuarioEmpleado>) repository.findAll();
    }

}
