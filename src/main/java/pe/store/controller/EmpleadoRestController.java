package pe.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Cargo;
import pe.store.model.Empleado;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private GenericService<Empleado,Integer> empService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Empleado> itemsEmp = empService.findAll();
        return new ResponseEntity<>(itemsEmp, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer empId)
    {
        Empleado emp = (Empleado) empService.findById(empId);
        if (emp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area no encontrado");
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Empleado emp)
    {
        empService.insert(emp);
        String respuesta = "Empleado "+ emp.getEmpId()+" - " +emp.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable(name = "id")  Integer empID)
    {
        Empleado emp = empService.findById(empID);
        if (emp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        empService.delete(empID);
        String respuesta = "Empleado "+ emp.getEmpId()+" - " +emp.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id")  Integer empID,@RequestBody Empleado updemp)
    {
        Empleado emp = empService.findById(empID);
        if (emp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        //actualizacion total!!!
        empService.update(updemp);
        String respuesta = "Empleado "+ emp.getEmpId()+" - " +emp.getNombre() +" actuaizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
}
