package pe.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Area;
import pe.store.service.AreaService;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Area> itemsArea = areaService.findAll();
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }

    @GetMapping("/buscarByName")
    public ResponseEntity<?> buscarByName(@RequestParam(name = "nombre") String nombre)
    {
        Collection<Area> itemsArea = areaService.findByName(nombre);
        return new ResponseEntity<>(itemsArea, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer areaId)
    {
        Area area = areaService.findById(areaId);
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

    @DeleteMapping("/borrar/{instructorID}")
    public ResponseEntity<?> borrar(@PathVariable Integer areaID)
    {
        Area instructor = areaService.findById(areaID);
        if (instructor == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        areaService.delete(areaID);
        Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
        respuesta.put("codigo","O0");
        respuesta.put("mensaje", "Se elimino correctamente el area con id : " + areaID);
        respuesta.put("fecOperacion",new Date().toString());
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{areaID}")
    public ResponseEntity<?> actualizar(@PathVariable Integer areaID,@RequestBody Area newArea)
    {
        Area area = areaService.findById(areaID);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        //actualizacion total!!!
        areaService.update(newArea);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /*@PatchMapping("/editar/{AreaID}")
    public ResponseEntity<?> actualizarParcial(@PathVariable Integer instructorID,@RequestBody Instructor newInstructor)
    {
        Instructor instructor = instructorService.findById(instructorID);
        if (instructor == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
        //Actualizar paracialmente
        instructor.setNombre(newInstructor.getNombre());
        instructor.setApellido(newInstructor.getApellido());
        instructorService.update(instructor);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }*/

}
