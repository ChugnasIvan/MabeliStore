package pe.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.store.model.Rol;

import java.util.List;

@Repository
public interface RolInterface {

    public List<Rol> listarRoles();
    public void agregar(Rol rol);
    public void actualizar(Rol rol);
    public void aliminar(Integer rolId);
    public Rol buscarRolXId(Integer rolId);


}
