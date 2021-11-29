package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.DetallePedido;

@Repository
public interface DetPedidoRepository extends CrudRepository<DetallePedido, Integer> {
}
