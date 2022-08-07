package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Person;
import com.educandoweb.course.repositories.PersonRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository  repository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById (Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Person insert(Person obj) {
		return repository.save(obj);
	}
	
	public void Delete (Long id) {
		repository.deleteById(id);
	}
	
	public Person update(Long id, Person obj) {
		Person entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void updateData(Person entity, Person obj ) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
