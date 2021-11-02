package pe.store.controller;

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
    public ResponseEntity<?> listar()
    {
        Collection<Cargo> itemsCargo = cargoService.findAll();
        return new ResponseEntity<>(itemsCargo, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer cargoId)
    {
        Cargo cargo = (Cargo) cargoService.findById(cargoId);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado");
        return new ResponseEntity<>(cargo, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Cargo cargo)
    {
        cargoService.insert(cargo);
        String respuesta = "Cargo "+ cargo.getCargoId()+" - " +cargo.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable(name = "id")  Integer cargoID)
    {
        Cargo cargo = cargoService.findById(cargoID);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado");
        cargoService.delete(cargoID);
        String respuesta = "Cargo "+ cargo.getCargoId()+" - " +cargo.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id")  Integer cargoID,@RequestBody Cargo updcargo)
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
