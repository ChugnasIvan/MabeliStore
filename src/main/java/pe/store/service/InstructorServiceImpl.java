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
		// TODO Auto-generated method stub
        repository.save(instructor); // pass through
	}

	@Override
	public void update(Instructor instructor) {
		// TODO Auto-generated method stub
       repository.save(instructor);
	}

	@Override
	public void delete(Integer instructorId) {
		// TODO Auto-generated method stub
       repository.deleteById(instructorId);
	}

	@Override
	public Instructor findById(Integer instructorId) {
		// TODO Auto-generated method stub
		return repository.findById(instructorId).orElse(null);
	}

	@Override
	public Collection<Instructor> findAll() {
		// TODO Auto-generated method stub
		return (Collection<Instructor>) repository.findAll();
	}

	@Override
	public Collection<Instructor> findByName(String name) {
		return repository.buscarPorNombre(name);
	}
}
