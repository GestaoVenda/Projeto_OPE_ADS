package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.SubMenu;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {

}
