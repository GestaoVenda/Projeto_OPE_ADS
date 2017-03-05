package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.DocumentAlreadyExistException;
import br.com.opeads.exception.DocumentDoesNotExistException;
import br.com.opeads.model.Document;
import br.com.opeads.model.Person;
import br.com.opeads.model.TypeDocument;
import br.com.opeads.repository.DocumentRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class DocumentService implements GenericInterfaceService<Document>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Document checkDocument;
	
	@Override
	public List<Document> read() {
		return documentRepository.findAll();
	}

	//Here we save the document by relating it with the client
	public Document createClientDocument(Long id, Document document) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		document.setIdPerson(client);
		verifyIfTheDocumentAlreadyExist(document);
		checkDocument = documentRepository.save(document);
		return checkDocument;
	}

	public void updateClientDocument(Long id,Document document) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		findById(document);
		document.setIdPerson(client);
		documentRepository.save(document);	
	}
	
	public Document createUserDocument(Long id, Document document) {
		Person client = new Person();
		client.setId(id);
		client = userService.findById(client);
		document.setIdPerson(client);
		verifyIfTheDocumentAlreadyExist(document);
		checkDocument = documentRepository.save(document);
		return checkDocument;
	}

	public void updateUserDocument(Long id,Document document) {
		Person client = new Person();
		client.setId(id);
		client = userService.findById(client);
		findById(document);
		document.setIdPerson(client);
		documentRepository.save(document);	
	}

	@Override
	public void delete(Document contact) {
		findById(contact);
		documentRepository.delete(contact);		
	}

	@Override
	public Document findById(Document document) {
		try{
			checkDocument = documentRepository.findByIdTypeDocumentAndIdPerson(document.getIdTypeDocument(),
					document.getIdPerson());
		}catch(RuntimeException e){
			throw new DocumentDoesNotExistException("O documento informado não existe!");
		}
		if(checkDocument == null) throw new DocumentDoesNotExistException("O endereco informado não existe!");
		return checkDocument;
	}
	
	public Document findByTypeAndValue(TypeDocument type, String value){
		return documentRepository.findByIdTypeDocumentAndValue(type, value);
	}
	
	public void verifyIfTheDocumentAlreadyExist(Document document){
		checkDocument = null;
		checkDocument = findByTypeAndValue(document.getIdTypeDocument(), document.getValue());
		if(checkDocument != null)throw new DocumentAlreadyExistException("O documento informado já foi cadastrado!");;
	}
}
