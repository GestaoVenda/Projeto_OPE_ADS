package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Document;
import br.com.opeads.model.Person;
import br.com.opeads.model.TypeDocument;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	public Document findByIdTypeDocumentAndValue(TypeDocument document, String value);
	
	public Document findByIdTypeDocumentAndIdPerson(TypeDocument document, Person person);
}
