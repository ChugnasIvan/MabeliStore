package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.UsuarioCliente;
import pe.store.service.GenericService;
import pe.store.service.UsuarioClienteService;

import java.util.Collection;

@RestController
@RequestMapping("/usuCliente")
public class UsuClienteRestController {

    @Autowired
    private GenericService<UsuarioCliente,Integer> usuCliService;

    @Autowired
    private UsuarioClienteService service;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas los UsuarioClientes", httpMethod = "GET", nickname = "listaUsuarioClientes")
    public ResponseEntity<?> listar()
    {
        Collection<UsuarioCliente> itemsArea = usuCliService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de los UsuarioClientes por ID", httpMethod = "GET", nickname = "listaUsuarioClienteByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del UsuarioCliente", required = true) @PathVariable(name = "id") Integer usuCliId)
    {
        UsuarioCliente usuCli = usuCliService.findById(usuCliId);
        if (usuCli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UsuarioCliente no encontrado");
        return new ResponseEntity<>(usuCli, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un UsuarioCliente", httpMethod = "POST", nickname = "RegistraUsuarioCliente")
    public ResponseEntity<?> agregar(@RequestBody UsuarioCliente usuCli)
    {
        service.saveUser(usuCli);
        String respuesta = "UsuarioCliente "+ usuCli.getIdUsuCli()+" - " +usuCli.getNombreUsuCli() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Usuario Cliente por ID", httpMethod = "DELETE", nickname = "EliminaUsuarioCliente")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del UsuarioCliente", required = true) @PathVariable(name = "id")  Integer usuCliID)
    {
        UsuarioCliente usuCli = usuCliService.findById(usuCliID);
        if (usuCli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UsuarioCliente no encontrado");
        usuCliService.delete(usuCliID);
        String respuesta = "UsuarioCliente "+ usuCli.getIdUsuCli()+" - " +usuCli.getIdUsuCli() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un Usuario Cliente por ID", httpMethod = "PUT", nickname = "ActualizaUsuarioCliente")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del UsuarioCliente", required = true) @PathVariable(name = "id")  Integer usuCliID,@RequestBody UsuarioCliente newUsuCli)
    {
        UsuarioCliente usuCli = usuCliService.findById(usuCliID);
        if (usuCli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UsuarioCliente no encontrado");
        //actualizacion total!!!
        usuCliService.update(newUsuCli);
        String respuesta = "UsuarioCliente "+ usuCli.getIdUsuCli()+" - " +usuCli.getNombreUsuCli() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
