package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.ContactAlreadyExistException;
import br.com.opeads.exception.ContactDoesNotExistException;
import br.com.opeads.model.Contact;
import br.com.opeads.model.Person;
import br.com.opeads.repository.ContactRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ContactService implements GenericInterfaceService<Contact> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private Contact checkContact;
	
	@Override
	public List<Contact> read() {
		return contactRepository.findAll();
	}

	//Here we save the contact by relating it with the client
	public Contact create(Long id, Contact contact) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		verifyContact(contact);
		contact.setIdPerson(client);
		checkContact = contactRepository.save(contact);
		return checkContact;
	}

	public void update(Long id,Contact contact) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		findById(contact);
		contact.setIdPerson(client);
		contactRepository.save(contact);	
	}

	@Override
	public void delete(Contact contact) {
		findById(contact);
		contactRepository.delete(contact);		
	}

	@Override
	public Contact findById(Contact contact) {
		try{
			checkContact = contactRepository.findOne(contact.getId());
		}catch(RuntimeException e){
			throw new ContactDoesNotExistException("O contato informado não existe!");
		}
		if(checkContact == null) throw new ContactDoesNotExistException("O contato informado não existe!");
		return checkContact;
	}
	
	private void verifyContact(Contact contact){
		checkContact = null;
		if(contact.getId() != null)checkContact = contactRepository.findOne(contact.getId());
		if(checkContact != null)throw new ContactAlreadyExistException("O contato informado já existe!");
	}
}
