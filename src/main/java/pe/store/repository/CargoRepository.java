package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Cargo;

@Repository
public interface CargoRepository  extends CrudRepository<Cargo, Integer> {

}
