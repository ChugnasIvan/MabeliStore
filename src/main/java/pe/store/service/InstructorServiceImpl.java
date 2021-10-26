package pe.store.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.store.model.Instructor;
import pe.store.repository.InstructorRepository;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

	@Autowired //Inyectame de manera automatica un bean que implemente dicha interfaz
	private InstructorRepository repository;

	@Override
	public void insert(Instructor instructor) {
        repository.save(instructor); // pass through
	}

	@Override
	public void update(Instructor instructor) {
       repository.save(instructor);
	}

	@Override
	public void delete(Integer instructorId) {
       repository.deleteById(instructorId);
	}

	@Override
	public Instructor findById(Integer instructorId) {
		return repository.findById(instructorId).orElse(null);
	}

	@Override
	public Collection<Instructor> findAll() {
		return (Collection<Instructor>) repository.findAll();
	}

	@Override
	public Collection<Instructor> findByName(String name) {
		return repository.buscarPorNombre(name);
	}
}
