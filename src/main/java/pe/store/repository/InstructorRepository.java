package pe.store.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.store.model.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

	
	@Query("SELECT i FROM Instructor i where i.nombre LIKE CONCAT(?1,'%')")
	public List<Instructor> buscarPorNombre(String nombre);
	
	/*
	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(Integer instructorId);
	public abstract Instructor findById(Integer instructorId);
	public abstract Collection<Instructor> findAll();*/


}
