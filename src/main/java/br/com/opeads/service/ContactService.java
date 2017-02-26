package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.ClientDoesNotExistsException;
import br.com.opeads.exception.ContactAlreadyExistsException;
import br.com.opeads.model.CellPhone;
import br.com.opeads.model.Client;
import br.com.opeads.model.Contact;
import br.com.opeads.model.Email;
import br.com.opeads.model.Phone;
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
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CellPhoneService cellphoneService;

	private Client client;
	
	@Override
	public List<Contact> read() {
		return contactRepository.findAll();
	}

	//Here we save the contact by relating it with the client
	//After this, we call the service to save the @OneToMany Contact attributes
	public Contact create(Long id, Contact contact) {
		client = null;
		Contact check = null;
		client.setId(id);
		client = clientService.findById(client);
		if(contact.getId() != null)check = contactRepository.findOne(contact.getId());
		if(check != null)throw new ContactAlreadyExistsException("O contato informado já existe");
		contact.setClient(client);
		check = contactRepository.save(contact);
		for(Phone phone: contact.getPhones()){
			phoneService.create(check.getId(), phone);
		}
		for(CellPhone cellPhone: contact.getCellPhones()){
			cellphoneService.create(check.getId(), cellPhone);
		}
		for(Email email: contact.getEmails()){
			emailService.create(check.getId(),email);
		}
		return check;
	}

	public void update(Long id,Contact contact) {
		Client client = new Client();
		client.setId(id);
		client = clientService.findById(client);
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
