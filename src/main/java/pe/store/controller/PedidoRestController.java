package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Pedido;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {

    @Autowired
    private GenericService<Pedido,Integer> pedidoService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los pedidos", httpMethod = "GET", nickname = "listaPedidos")
    public ResponseEntity<?> listar()
    {
        Collection<Pedido> itemsArea = pedidoService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las areas por ID", httpMethod = "GET", nickname = "listaPedidoByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Pedido", required = true) @PathVariable(name = "id") Integer pedidoId)
    {
        Pedido pedido = pedidoService.findById(pedidoId);
        if (pedido == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado");
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra una pedido", httpMethod = "POST", nickname = "RegistraPedido")
    public ResponseEntity<?> agregar(@RequestBody Pedido pedido)
    {
        pedidoService.insert(pedido);
        String respuesta = "Pedido "+ pedido.getPedidoId() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Pedido por ID", httpMethod = "DELETE", nickname = "EliminaPedido")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Pedido", required = true) @PathVariable(name = "id")  Integer pedidoID)
    {
        Pedido pedido = pedidoService.findById(pedidoID);
        if (pedido == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado");
        pedidoService.delete(pedidoID);
        String respuesta = "Pedido "+ pedido.getPedidoId() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza Pedido por ID", httpMethod = "PUT", nickname = "ActualizaPedido")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Pedido", required = true) @PathVariable(name = "id")  Integer pedidoID,@RequestBody Pedido newPedido)
    {
        Pedido pedido = pedidoService.findById(pedidoID);
        if (pedido == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado");
        //actualizacion total!!!
        pedidoService.update(newPedido);
        String respuesta = "Pedido "+ pedido.getPedidoId() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
