package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Cliente;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private GenericService<Cliente,Integer> cliService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los Cliente", httpMethod = "GET", nickname = "listaClientes")
    public ResponseEntity<?> listar()
    {
        Collection<Cliente> itemsArea = cliService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de los Cliente por ID", httpMethod = "GET", nickname = "listaClienteByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del cliente", required = true) @PathVariable(name = "id") Integer cliId)
    {
        Cliente cli = cliService.findById(cliId);
        if (cli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        return new ResponseEntity<>(cli, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un Cliente", httpMethod = "POST", nickname = "RegistraCliente")
    public ResponseEntity<?> agregar(@RequestBody Cliente cli)
    {
        cliService.insert(cli);
        String respuesta = "Cliente "+ cli.getIdCliente()+" - " +cli.getNombreCli() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Cliente por ID", httpMethod = "DELETE", nickname = "EliminaCliente")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Cliente", required = true) @PathVariable(name = "id")  Integer cliID)
    {
        Cliente cli = cliService.findById(cliID);
        if (cli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        cliService.delete(cliID);
        String respuesta = "Cliente "+ cli.getIdCliente()+" - " +cli.getNombreCli()+" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un Cliente por ID", httpMethod = "PUT", nickname = "ActualizaCliente")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Cliente", required = true) @PathVariable(name = "id")  Integer cliID,@RequestBody Cliente newCli)
    {
        Cliente cli = cliService.findById(cliID);
        if (cli == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        //actualizacion total!!!
        cliService.update(newCli);
        String respuesta = "Cliente "+ cli.getIdCliente()+" - " +cli.getNombreCli() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
