package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opeads.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
