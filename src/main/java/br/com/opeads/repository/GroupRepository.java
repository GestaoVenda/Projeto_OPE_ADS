package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}
