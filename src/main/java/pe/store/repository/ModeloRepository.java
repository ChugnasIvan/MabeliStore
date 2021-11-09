package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Modelo;

@Repository
public interface ModeloRepository extends CrudRepository<Modelo, Integer> {
}
