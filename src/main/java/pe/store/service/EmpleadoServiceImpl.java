package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Empleado;
import pe.store.repository.EmpleadoRepository;

import java.util.Collection;

@Service
public class EmpleadoServiceImpl implements GenericService<Empleado,Integer>{

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private EmpleadoRepository repository;

    @Override
    public void insert(Empleado obj) {
        repository.save(obj);
    }

    @Override
    public void update(Empleado obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Empleado findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Empleado> findAll() {
        return (Collection<Empleado>) repository.findAll();
    }

}
