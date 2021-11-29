package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Proveedor;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {

    @Autowired
    private GenericService<Proveedor,Integer> provService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas los proveedores", httpMethod = "GET", nickname = "listaProveedores")
    public ResponseEntity<?> listar()
    {
        Collection<Proveedor> itemsProv = provService.findAll();
        return new ResponseEntity<>(itemsProv, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de proveedor por ID", httpMethod = "GET", nickname = "listaProveedorByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Proveedor", required = true) @PathVariable(name = "id") Integer provId)
    {
        Proveedor prov = provService.findById(provId);
        if (prov == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        return new ResponseEntity<>(prov, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un Proveedor", httpMethod = "POST", nickname = "RegistraProveedor")
    public ResponseEntity<?> agregar(@RequestBody Proveedor prov)
    {
        provService.insert(prov);
        String respuesta = "Proveedor "+ prov.getProvId()+" - " +prov.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Proveedor por ID", httpMethod = "DELETE", nickname = "EliminaProveedor")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Proveedor", required = true) @PathVariable(name = "id")  Integer provID)
    {
        Proveedor prov = provService.findById(provID);
        if (prov == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        provService.delete(provID);
        String respuesta = "Proveedor "+ prov.getProvId()+" - " +prov.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un Proveedor por ID", httpMethod = "PUT", nickname = "ActualizaProveedor")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Proveedor", required = true) @PathVariable(name = "id")  Integer provID,@RequestBody Proveedor newProv)
    {
        Proveedor prov = provService.findById(provID);
        if (prov == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        //actualizacion total!!!
        provService.update(newProv);
        String respuesta = "Proveedor "+ prov.getProvId()+" - " +prov.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
}
