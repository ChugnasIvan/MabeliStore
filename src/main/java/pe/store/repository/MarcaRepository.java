package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {
}
