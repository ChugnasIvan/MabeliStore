package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Area;
import pe.store.model.Cargo;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/cargo")
public class CargoRestController {

    @Autowired
    private GenericService<Cargo,Integer> cargoService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas la cargos", httpMethod = "GET", nickname = "listaCargos")
    public ResponseEntity<?> listar()
    {
        Collection<Cargo> itemsCargo = cargoService.findAll();
        return new ResponseEntity<>(itemsCargo, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las cargos por ID", httpMethod = "GET", nickname = "listaCargoByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del cargo", required = true) @PathVariable(name = "id") Integer cargoId)
    {
        Cargo cargo = (Cargo) cargoService.findById(cargoId);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado");
        return new ResponseEntity<>(cargo, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un cargo", httpMethod = "POST", nickname = "RegistraCargo")
    public ResponseEntity<?> agregar(@RequestBody Cargo cargo)
    {
        cargoService.insert(cargo);
        String respuesta = "Cargo "+ cargo.getCargoId()+" - " +cargo.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un cargo por ID", httpMethod = "DELETE", nickname = "EliminaCargo")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del cargo", required = true) @PathVariable(name = "id")  Integer cargoID)
    {
        Cargo cargo = cargoService.findById(cargoID);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado");
        cargoService.delete(cargoID);
        String respuesta = "Cargo "+ cargo.getCargoId()+" - " +cargo.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un cargo por ID", httpMethod = "PUT", nickname = "ActualizaCargo")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del cargo", required = true) @PathVariable(name = "id")  Integer cargoID, @RequestBody Cargo updcargo)
    {
        Cargo cargo = cargoService.findById(cargoID);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado");
        //actualizacion total!!!
        cargoService.update(updcargo);
        String respuesta = "Cargo "+ cargo.getCargoId()+" - " +cargo.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
}
