package br.com.opeads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opeads.model.Person;
import br.com.opeads.model.TypePerson;

public interface PersonRepository extends JpaRepository<Person, Long>{

	List<Person> findByTypePersonOrTypePerson(TypePerson type1,TypePerson type2 );
	
	List<Person> findByTypePerson(TypePerson type);
}
