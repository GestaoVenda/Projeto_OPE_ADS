package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

}
