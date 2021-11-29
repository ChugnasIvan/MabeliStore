package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Rol;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/rol")
public class RolRestController {
    @Autowired
    private GenericService<Rol,Integer> rolService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas los roles", httpMethod = "GET", nickname = "listaRoles")
    public ResponseEntity<?> listar()
    {
        Collection<Rol> itemsRol = rolService.findAll();
        return new ResponseEntity<>(itemsRol, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las areas por ID", httpMethod = "GET", nickname = "listaRolByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Rol", required = true) @PathVariable(name = "id") Integer rolId)
    {
        Rol rol = rolService.findById(rolId);
        if (rol == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un rol", httpMethod = "POST", nickname = "RegistraRol")
    public ResponseEntity<?> agregar(@RequestBody Rol rol)
    {
        rolService.insert(rol);
        String respuesta = "Rol "+ rol.getIdRol()+" - " +rol.getNombreRol() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un rol por ID", httpMethod = "DELETE", nickname = "EliminaRol")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del rol", required = true) @PathVariable(name = "id")  Integer rolID)
    {
        Rol rol = rolService.findById(rolID);
        if (rol == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        rolService.delete(rolID);
        String respuesta = "Rol "+ rol.getIdRol()+" - " +rol.getNombreRol() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un rol por ID", httpMethod = "PUT", nickname = "ActualizaRol")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del rol", required = true) @PathVariable(name = "id")  Integer rolID,@RequestBody Rol newRol)
    {
        Rol area = rolService.findById(rolID);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        //actualizacion total!!!
        rolService.update(newRol);
        String respuesta = "Rol "+ area.getIdRol()+" - " + newRol.getNombreRol() +" actualizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
