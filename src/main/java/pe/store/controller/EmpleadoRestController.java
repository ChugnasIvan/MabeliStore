package pe.store.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Empleado;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private GenericService<Empleado,Integer> empService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todos los empleados", httpMethod = "GET", nickname = "listaEmpleado")
    public ResponseEntity<?> listar()
    {
        Collection<Empleado> itemsEmp = empService.findAll();
        return new ResponseEntity<>(itemsEmp, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de lOS Empleados por ID", httpMethod = "GET", nickname = "listaEmpleadoByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Empleado", required = true) @PathVariable(name = "id") Integer empId)
    {
        Empleado emp = (Empleado) empService.findById(empId);
        if (emp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    @ApiOperation(value = "Registra un Empleado", httpMethod = "POST", nickname = "RegistraEmpleado")
    public ResponseEntity<?> agregar(@RequestBody Empleado emp)
    {
        empService.insert(emp);
        String respuesta = "Empleado "+ emp.getEmpId()+" - " +emp.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina un Empleado por ID", httpMethod = "DELETE", nickname = "EliminaEmpleado")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Empleado", required = true) @PathVariable(name = "id")  Integer empID)
    {
        Empleado emp = empService.findById(empID);
        if (emp == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        empService.delete(empID);
        String respuesta = "Empleado "+ emp.getEmpId()+" - " +emp.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza un Empleado por ID", httpMethod = "PUT", nickname = "ActualizaEmpleado")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Empleado", required = true) @PathVariable(name = "id")  Integer empID,@RequestBody Empleado updemp)
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
