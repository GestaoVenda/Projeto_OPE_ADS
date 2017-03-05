package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.TypePerson;

@Repository
public interface TypePersonRepository extends JpaRepository<TypePerson, Long>{

}
