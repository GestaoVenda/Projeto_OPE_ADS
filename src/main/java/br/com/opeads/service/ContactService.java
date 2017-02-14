package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.ClientDoesNotExistsException;
import br.com.opeads.Exception.ContactAlreadyExistsException;
import br.com.opeads.model.Client;
import br.com.opeads.model.Contact;
import br.com.opeads.repository.ContactRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ContactService implements GenericInterfaceService<Contact>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992280903953485234L;

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public List<Contact> read() {
		return contactRepository.findAll();
	}

	public Contact create(Long id, Contact contact) {
		Client client = new Client();
		Contact check = null;
		client.setId(id);
		client = clientService.buscaPorId(client);
		if(contact.getId() != null)check = contactRepository.findOne(contact.getId());
		if(check != null)throw new ContactAlreadyExistsException("O contato informado já existe");
		contact.setClient(client);
		return contactRepository.save(contact);
	}

	public void update(Long id,Contact contact) {
		Client client = new Client();
		client.setId(id);
		client = clientService.buscaPorId(client);
		findById(contact);
		contact.setClient(client);
		contactRepository.save(contact);	
	}

	@Override
	public void delete(Contact contact) {
		findById(contact);
		contactRepository.delete(contact);		
	}

	@Override
	public Contact findById(Contact contact) {
		Contact check = contactRepository.findOne(contact.getId());
		if(check == null)throw new ClientDoesNotExistsException("O contato informado não existe");
		return check;
	}

}
