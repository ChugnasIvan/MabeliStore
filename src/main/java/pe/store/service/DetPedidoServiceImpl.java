package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.store.model.Area;
import pe.store.model.DetallePedido;
import pe.store.repository.DetPedidoRepository;

import java.util.Collection;

@Service
public class DetPedidoServiceImpl implements GenericService<DetallePedido,Integer>{

    @Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
    private DetPedidoRepository repository;

    @Override
    public void insert(DetallePedido obj) {
        repository.save(obj);
    }

    @Override
    public void update(DetallePedido obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public DetallePedido findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<DetallePedido> findAll() {
        return (Collection<DetallePedido>) repository.findAll();
    }
}
