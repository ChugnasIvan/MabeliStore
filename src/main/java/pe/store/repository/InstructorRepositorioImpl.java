package pe.store.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import pe.store.model.Instructor;

@Repository // gestioname en tu contexto de IoC--Spring
public class InstructorRepositorioImpl{

	// Atributo sea nivel de clase, que todos los objetos de esa clase van a
	// referenciar a la misma informacion guardada en memoria.
	private static Collection<Instructor> itemsInstructor = new ArrayList<>();

	@PostConstruct // ? le estas diciendo al ctx Spring IoC que automaticamente ejecute este metodo
					// post instanciacion.
	public void initData() {
		Instructor instructor1 = new Instructor(1, "Christian", "Castillo", "11111", "d18361@idat.edu.pe", new Date());
		Instructor instructor2 = new Instructor(2, "Pedro", "Castillo", "11111", "d18362@idat.edu.pe", new Date());
		itemsInstructor.add(instructor1);
		itemsInstructor.add(instructor2);
	}

	//@Override
	public void insert(Instructor instructor) {
		itemsInstructor.add(instructor);
	}

	//@Override
	public void update(Instructor instructor) {
		// ubico el actual
		Instructor oldInstructor = findById(instructor.getInstructorId());
		// borrar el actual de la lista
		itemsInstructor.remove(oldInstructor);
		// crear el nuevo en la lista
		itemsInstructor.add(instructor);
	}

	//@Override
	public void delete(Integer instructorId) {
		// ubico el actual
		Instructor oldInstructor = findById(instructorId);
		// borrar el actual de la lista
		itemsInstructor.remove(oldInstructor);
	}

	//@Override
	public Instructor findById(Integer instructorId) {
		Optional<Instructor> instructor = itemsInstructor.stream().filter(p -> p.getInstructorId() == instructorId)
				.findFirst();
		return instructor.orElse(null);
	}

	//@Override
	public Collection<Instructor> findAll() {
		return itemsInstructor;
	}

}
