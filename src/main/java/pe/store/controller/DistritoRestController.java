package pe.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Area;
import pe.store.model.Distrito;
import pe.store.service.GenericService;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {

    @Autowired
    private GenericService<Distrito,Integer> distritoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Distrito> itemsDistrito = distritoService.findAll();
        return new ResponseEntity<>(itemsDistrito, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer disId)
    {
        Distrito distrito = (Distrito) distritoService.findById(disId);
        if (distrito == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado");
        return new ResponseEntity<>(distrito, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Distrito distrito)
    {
        distritoService.insert(distrito);
        String respuesta = "Distrito "+ distrito.getIdDis()+" - " +distrito.getDescripcion() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable(name = "id") Integer distritoID)
    {
        Distrito distrito = distritoService.findById(distritoID);
        if (distrito == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado");
        distritoService.delete(distritoID);
        String respuesta = "Distrito "+ distrito.getIdDis()+" - " +distrito.getDescripcion() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id") Integer distritoID,@RequestBody Distrito newDis)
    {
        Distrito distrito = distritoService.findById(distritoID);
        if (distrito == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado");
        //actualizacion total!!!
        distritoService.update(newDis);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
