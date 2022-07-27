package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
