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
@RequestMapping("/area")
public class AreaRestController {

    @Autowired
    private GenericService<Area,Integer> areaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Area> itemsArea = areaService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer areaId)
    {
        Area area = (Area) areaService.findById(areaId);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Area area)
    {
        areaService.insert(area);
        String respuesta = "Area "+ area.getAreaId()+" - " +area.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable(name = "id")  Integer areaID)
    {
        Area area = areaService.findById(areaID);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        areaService.delete(areaID);
        String respuesta = "Area "+ area.getAreaId()+" - " +area.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id")  Integer areaID,@RequestBody Area newArea)
    {
        Area area = areaService.findById(areaID);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        //actualizacion total!!!
        areaService.update(newArea);
        String respuesta = "Area "+ area.getAreaId()+" - " +area.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

}
