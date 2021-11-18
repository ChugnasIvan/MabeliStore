package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Modelo;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/modelo")
public class ModeloRestController {

    @Autowired
    private GenericService<Modelo,Integer> modeloService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los Modelo", httpMethod = "GET", nickname = "listaModelos")
    public ResponseEntity<?> listar()
    {
        Collection<Modelo> itemsModelo = modeloService.findAll();
        return new ResponseEntity<>(itemsModelo, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las Modelos por ID", httpMethod = "GET", nickname = "listaModeloByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Modelo", required = true) @PathVariable(name = "id") Integer modeloId)
    {
        Modelo modelo = modeloService.findById(modeloId);
        if (modelo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado");
        return new ResponseEntity<>(modelo, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra una Modelo", httpMethod = "POST", nickname = "RegistraModelo")
    public ResponseEntity<?> agregar(@RequestBody Modelo modelo)
    {
        modeloService.insert(modelo);
        String respuesta = "Modelo "+ modelo.getModeloId()+" - " +modelo.getNombre()+" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Modelo por ID", httpMethod = "DELETE", nickname = "EliminaModelo")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Modelo", required = true) @PathVariable(name = "id")  Integer modeloID)
    {
        Modelo modelo = modeloService.findById(modeloID);
        if (modelo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado");
        modeloService.delete(modeloID);
        String respuesta = "Modelo "+ modelo.getModeloId()+" - " +modelo.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza una modelo por ID", httpMethod = "PUT", nickname = "ActualizaModelo")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del modelo", required = true) @PathVariable(name = "id")  Integer modeloID,@RequestBody Modelo newModelo)
    {
        Modelo modelo = modeloService.findById(modeloID);
        if (modelo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado");
        //actualizacion total!!!
        modeloService.update(newModelo);
        String respuesta = "Modelo "+ modelo.getModeloId()+" - " +modelo.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
