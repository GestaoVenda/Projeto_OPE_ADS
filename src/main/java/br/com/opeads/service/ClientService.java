package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.ClientAlreadyExistException;
import br.com.opeads.exception.ClientDoesNotExistException;
import br.com.opeads.model.Address;
import br.com.opeads.model.Contact;
import br.com.opeads.model.Document;
import br.com.opeads.model.Person;
import br.com.opeads.model.TypePerson;
import br.com.opeads.repository.PersonRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ClientService implements GenericInterfaceService<Person>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Person checkPerson;
	
	@Autowired
	private Document checkDocument;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressService addressService;
	
	//Here we save the client
	//After this we save the contact, address and the documents
	public Person create(Person client){
		checkPerson = new Person();
		verifyDocuments(client);
		checkPerson = personRepository.save(client);
		if(client.getContacts() != null){
			for(Contact contact: client.getContacts()){
				contactService.create(checkPerson.getId(), contact);
			}
		}
		if(client.getAddresses() != null){
			for(Address address: client.getAddresses()){
				addressService.createClientAddress(checkPerson.getId(), address);
			}
		}
		if(client.getDocuments() != null){
			for(Document document: client.getDocuments()){
				documentService.create(checkPerson.getId(), document);
			}
		}
		return checkPerson ;
	}
	
	public void update(Person client){
		findById(client);
		personRepository.save(client);
		if(client.getContacts() != null){
			for(Contact contact: client.getContacts()){
				contactService.update(client.getId(), contact);
			}
		}
		if(client.getAddresses() != null){
			for(Address address: client.getAddresses()){
				addressService.updateClientAddress(client.getId(), address);
			}
		}
		if(client.getDocuments() != null){
			for(Document document: client.getDocuments()){
				documentService.update(client.getId(), document);
			}
		}
	}

	@Override
	public List<Person> read() {
		TypePerson type1 = new TypePerson();
		TypePerson type2 = new TypePerson();
		type1.setId(1L);
		type2.setId(2L);
		return personRepository.findByTypePersonOrTypePerson(type1,type2);
	}

	@Override
	public void delete(Person client) {
		findById(client);
		personRepository.delete(client);
	}

	@Override
	public Person findById(Person client) {
		checkPerson = null;
		try {
		checkPerson = personRepository.findOne(client.getId());
		}catch(RuntimeException e){
			throw new ClientDoesNotExistException("Cliente não existe!");			
		}
		if(checkPerson == null) throw new ClientDoesNotExistException("Cliente não existe!");
		return checkPerson;
	}
	
	private void verifyDocuments(Person client){
		checkDocument = null;
		checkPerson = null;
		for (Document document : client.getDocuments()) {
			if(client.getId() != null) checkPerson = personRepository.findOne(client.getId());
			if(document.getIdTypeDocument().getName() == "cnpj" && document.getValue() != null)
				checkDocument = documentService.findByTypeAndValue(document.getIdTypeDocument(), document.getValue());
			if(document.getIdTypeDocument().getName() == "cpf" && document.getValue() != null)
				checkDocument = documentService.findByTypeAndValue(document.getIdTypeDocument(), document.getValue());
			if(document.getIdTypeDocument().getName() == "insc_estadual" && document.getValue() != null)
				checkDocument = documentService.findByTypeAndValue(document.getIdTypeDocument(), document.getValue());
			if(document.getIdTypeDocument().getName() == "insc_municipal" && document.getValue() != null)
				checkDocument = documentService.findByTypeAndValue(document.getIdTypeDocument(), document.getValue());
			if(checkDocument != null || checkPerson != null) throw new ClientAlreadyExistException("Cliente informado já existe!");		
		}	
	}

}
