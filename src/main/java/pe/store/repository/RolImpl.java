package pe.store.repository;

import org.springframework.stereotype.Repository;
import pe.store.model.Rol;

import java.util.List;

@Repository
public class RolImpl implements RolInterface{
    @Override
    public List<Rol> listarRoles() {
        return null;
    }

    @Override
    public void agregar(Rol rol) {

    }

    @Override
    public void actualizar(Rol rol) {

    }

    @Override
    public void aliminar(Integer rolId) {

    }

    @Override
    public Rol buscarRolXId(Integer rolId) {
        return null;
    }
}
