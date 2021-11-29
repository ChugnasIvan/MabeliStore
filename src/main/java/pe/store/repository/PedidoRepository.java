package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
