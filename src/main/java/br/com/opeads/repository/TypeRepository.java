package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opeads.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
