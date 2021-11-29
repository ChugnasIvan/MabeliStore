package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {


}

