package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Producto;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    private GenericService<Producto,Integer> areaService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los productos", httpMethod = "GET", nickname = "listaProducto")
    public ResponseEntity<?> listar()
    {
        Collection<Producto> itemsProducto = areaService.findAll();
        return new ResponseEntity<>(itemsProducto, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las areas por ID", httpMethod = "GET", nickname = "listaProductoByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del producto", required = true) @PathVariable(name = "id") Integer areaId)
    {
        Producto area =  areaService.findById(areaId);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        return new ResponseEntity<>(area, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra una area", httpMethod = "POST", nickname = "RegistraProducto")
    public ResponseEntity<?> agregar(@RequestBody Producto prod)
    {
        areaService.insert(prod);
        String respuesta = "Producto "+ prod.getProdId() +" - " +prod.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina una area por ID", httpMethod = "DELETE", nickname = "EliminaProducto")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Producto", required = true) @PathVariable(name = "id")  Integer prodID)
    {
        Producto prod = areaService.findById(prodID);
        if (prod == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "producto no encontrado");
        areaService.delete(prodID);
        String respuesta = "producto "+ prod.getProdId()+" - " +prod.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza una Producto por ID", httpMethod = "PUT", nickname = "ActualizaProducto")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del producto", required = true) @PathVariable(name = "id")  Integer prodID,@RequestBody Producto newProducto)
    {
        Producto prod = areaService.findById(prodID);
        if (prod == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        //actualizacion total!!!
        areaService.update(newProducto);
        String respuesta = "Producto "+ prod.getProdId()+" - " +prod.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


}
