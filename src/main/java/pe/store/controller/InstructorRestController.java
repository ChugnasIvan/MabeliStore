package pe.store.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.store.model.Instructor;
import pe.store.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorRestController {

	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar()  
	{
	   Collection<Instructor> itemsInstructor = instructorService.findAll();
	   return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
	}
	
	
	@GetMapping("/buscarByName")
	public ResponseEntity<?> buscarByName(@RequestParam(name = "nombre") String nombre)  
	{
	   Collection<Instructor> itemsInstructor = instructorService.findByName(nombre);
	   return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
	}
	   
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer instructorId)
	{
		Instructor instructor = instructorService.findById(instructorId);
		if (instructor == null)
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
		return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Instructor instructor)
	{
		instructorService.insert(instructor);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/borrar/{instructorID}")
    public ResponseEntity<?> borrar(@PathVariable Integer instructorID)
    {
    	Instructor instructor = instructorService.findById(instructorID);
		if (instructor == null)
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
		instructorService.delete(instructorID);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el instructor con id : " + instructorID);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
	
	
	@PutMapping("/editar/{instructorID}")
	public ResponseEntity<?> actualizar(@PathVariable Integer instructorID,@RequestBody Instructor newInstructor)
	{
		Instructor instructor = instructorService.findById(instructorID);
		if (instructor == null)
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
		//actualizacion total!!!
		instructorService.update(newInstructor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/editar/{instructorID}")
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
	}
	
}
