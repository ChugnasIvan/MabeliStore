package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.DetallePedido;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/detPedido")
public class DetPedidoRestController {

    @Autowired
    private GenericService<DetallePedido,Integer> detalleService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los detalles", httpMethod = "GET", nickname = "listaDetallePedidos")
    public ResponseEntity<?> listar()
    {
        Collection<DetallePedido> itemsArea = detalleService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de los DetallePedido por ID", httpMethod = "GET", nickname = "listaDetallePedidoByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del DetallePedido", required = true) @PathVariable(name = "id") Integer detalleId)
    {
        DetallePedido detalle = detalleService.findById(detalleId);
        if (detalle == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DetallePedido no encontrado");
        return new ResponseEntity<>(detalle, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un DetallePedido", httpMethod = "POST", nickname = "RegistraDetallePedido")
    public ResponseEntity<?> agregar(@RequestBody DetallePedido detalle)
    {
        detalleService.insert(detalle);
        String respuesta = "DetallePedido agrego correctamente el producto"+ detalle.getProducto().getProdId();
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un correctamente por ID", httpMethod = "DELETE", nickname = "EliminaDetallePedido")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del DetallePedido", required = true) @PathVariable(name = "id")  Integer detalleID)
    {
        DetallePedido detalle = detalleService.findById(detalleID);
        if (detalle == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DetallePedido no encontrado");
        detalleService.delete(detalleID);
        String respuesta = "Producto "+ detalle.getProducto().getProdId() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un DetallePedido por ID", httpMethod = "PUT", nickname = "ActualizaArea")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del DetallePedido", required = true) @PathVariable(name = "id")  Integer detalleID,@RequestBody DetallePedido newDetalle)
    {
        DetallePedido detalle = detalleService.findById(detalleID);
        if (detalle == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DetallePedido no encontrado");
        //actualizacion total!!!
        detalleService.update(newDetalle);
        String respuesta = "DetallePedido "+ detalle.getProducto().getProdId() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
