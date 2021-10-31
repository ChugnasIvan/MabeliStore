package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Integer> {
}
