package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
