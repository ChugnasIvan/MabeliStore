package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.Pedido;
import pe.store.repository.PedidoRepository;

import java.util.Collection;

@Service
public class PedidoServiceImpl implements GenericService<Pedido,Integer>{

    @Autowired
    private PedidoRepository repository;

    @Override
    public void insert(Pedido obj) {
        repository.save(obj);
    }

    @Override
    public void update(Pedido obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Pedido findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Pedido> findAll() {
        return (Collection<Pedido>) repository.findAll();
    }
}
