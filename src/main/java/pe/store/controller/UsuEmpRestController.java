package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Empleado;
import pe.store.model.UsuarioEmpleado;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/usuEmp")
public class UsuEmpRestController {

    @Autowired
    private GenericService<UsuarioEmpleado,Integer> usuEmpService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los usuarios", httpMethod = "GET", nickname = "listaUsuarios")
    public ResponseEntity<?> listar()
    {
        Collection<UsuarioEmpleado> itemsUsuEmp = usuEmpService.findAll();
        return new ResponseEntity<>(itemsUsuEmp, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de los usuarios por ID", httpMethod = "GET", nickname = "listaUsuarioByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del usuario", required = true) @PathVariable(name = "id") Integer usuId)
    {
        UsuarioEmpleado usuEmp = (UsuarioEmpleado) usuEmpService.findById(usuId);
        if (usuEmp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        return new ResponseEntity<>(usuEmp, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un usuario", httpMethod = "POST", nickname = "RegistraUsuario")
    public ResponseEntity<?> agregar(@RequestBody UsuarioEmpleado usuEmp)
    {
        usuEmpService.insert(usuEmp);
        String respuesta = "Usuario "+ usuEmp.getUsuEmpId()+" - " +usuEmp.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un usuario por ID", httpMethod = "DELETE", nickname = "EliminaUsuario")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del usuario", required = true) @PathVariable(name = "id")  Integer usuEmpId)
    {
        UsuarioEmpleado usuEmp = usuEmpService.findById(usuEmpId);
        if (usuEmp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Empleado  no encontrado");
        usuEmpService.delete(usuEmpId);
        String respuesta = "Usuario Empleado  "+ usuEmp.getUsuEmpId()+" - " +usuEmp.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un usuario por ID", httpMethod = "PUT", nickname = "ActualizaUsuario")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del usuario", required = true) @PathVariable(name = "id")  Integer usuEmpID, @RequestBody UsuarioEmpleado updUsuEmp)
    {
        UsuarioEmpleado usuEmp = usuEmpService.findById(usuEmpID);
        if (usuEmp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Empleado  no encontrado");
        //actualizacion total!!!
        usuEmpService.update(updUsuEmp);
        String respuesta = "Usuario Empleado  "+ usuEmp.getUsuEmpId()+" - " +usuEmp.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
