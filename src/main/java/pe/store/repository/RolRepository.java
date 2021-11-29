package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
}
