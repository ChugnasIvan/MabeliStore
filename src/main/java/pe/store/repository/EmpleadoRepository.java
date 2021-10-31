package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {


}
