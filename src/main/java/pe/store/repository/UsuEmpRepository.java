package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.UsuarioEmpleado;

@Repository
public interface UsuEmpRepository extends CrudRepository<UsuarioEmpleado, Integer> {


}
