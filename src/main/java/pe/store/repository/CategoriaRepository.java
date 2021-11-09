package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
