package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {

}
