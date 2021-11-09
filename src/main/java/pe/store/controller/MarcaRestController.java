package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Marca;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/marca")
public class MarcaRestController {

    @Autowired
    private GenericService<Marca,Integer> marcaService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas las marcas", httpMethod = "GET", nickname = "listaMarcass")
    public ResponseEntity<?> listar()
    {
        Collection<Marca> itemsMarca = marcaService.findAll();
        return new ResponseEntity<>(itemsMarca, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las marcas por ID", httpMethod = "GET", nickname = "listaMarcaByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Marca", required = true) @PathVariable(name = "id") Integer marcaId)
    {
        Marca marca =  marcaService.findById(marcaId);
        if (marca == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "marca no encontrado");
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra una marca", httpMethod = "POST", nickname = "RegistraMarca")
    public ResponseEntity<?> agregar(@RequestBody Marca marca)
    {
        marcaService.insert(marca);
        String respuesta = "Area "+ marca.getMarcaId()+" - " +marca.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina una marca por ID", httpMethod = "DELETE", nickname = "EliminaMarca")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Marca", required = true) @PathVariable(name = "id")  Integer marcaID)
    {
        Marca marca = marcaService.findById(marcaID);
        if (marca == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca no encontrado");
        marcaService.delete(marcaID);
        String respuesta = "Area "+ marca.getMarcaId()+" - " +marca.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza una area por ID", httpMethod = "PUT", nickname = "ActualizaMarca")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Marca", required = true) @PathVariable(name = "id")  Integer marcaID,@RequestBody Marca newArea)
    {
        Marca marca = marcaService.findById(marcaID);
        if (marca == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        //actualizacion total!!!
        marcaService.update(newArea);
        String respuesta = "Area "+ marca.getMarcaId()+" - " +marca.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
}
