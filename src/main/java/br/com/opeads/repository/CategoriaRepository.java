package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
