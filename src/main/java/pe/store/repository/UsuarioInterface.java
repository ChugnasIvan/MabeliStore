package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioInterface{
    public List<Usuario> listarUsuario();
    public void agregar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void aliminar(Integer usuarioId);
    public Usuario buscarRolXId(Integer usuarioId);
}
