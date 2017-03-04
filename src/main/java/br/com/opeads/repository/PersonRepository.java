package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opeads.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
