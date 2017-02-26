package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.CellPhone;

@Repository
public interface CellPhoneRepository extends JpaRepository<CellPhone, Long>{

}
