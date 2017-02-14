package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
