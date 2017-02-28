package br.com.opeads.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
