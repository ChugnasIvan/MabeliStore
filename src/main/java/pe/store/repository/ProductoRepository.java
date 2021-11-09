package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
