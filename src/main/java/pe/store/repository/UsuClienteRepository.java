package pe.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.UsuarioCliente;

import java.util.Optional;

@Repository
public interface UsuClienteRepository extends JpaRepository<UsuarioCliente, Integer> {

    Optional<UsuarioCliente>
    findUserUsuarioClienteByNombreUsuCli(String nombreUsuCli);

}
