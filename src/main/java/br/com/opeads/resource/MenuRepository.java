package br.com.opeads.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
