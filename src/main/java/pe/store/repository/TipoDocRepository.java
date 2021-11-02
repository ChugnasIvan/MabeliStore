package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.TipoDocumento;

@Repository
public interface TipoDocRepository extends CrudRepository<TipoDocumento, Integer> {
}
