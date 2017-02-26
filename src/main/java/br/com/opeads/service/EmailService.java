package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.EmailAlreadyExistsException;
import br.com.opeads.exception.EmailDoesNotExistsException;
import br.com.opeads.model.Contact;
import br.com.opeads.model.Email;
import br.com.opeads.repository.EmailRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class EmailService implements GenericInterfaceService<Email>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2606593246828682266L;
	
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private ContactService contactService;


	private Contact contact;
	
	public Email create(Long id, Email email) {
		Email check = null;
		contact = new Contact();
		contact.setId(id);
		contact = contactService.findById(contact);
		if(email.getId() != null)check = emailRepository.findOne(email.getId());
		if(check != null)throw new EmailAlreadyExistsException("O email informado já existe");
		email.setContact(contact);
		return emailRepository.save(email);
	}

	@Override
	public List<Email> read() {
		return emailRepository.findAll();
	}

	@Override
	public void delete(Email email) {
		findById(email);
		emailRepository.delete(email);
	}

	@Override
	public Email findById(Email email) {
		Email check = emailRepository.findOne(email.getId());
		if(check == null)throw new EmailDoesNotExistsException("O email informado não existe");
		return emailRepository.findOne(email.getId());
	}
	
	public void update(Long id, Email email) {
		contact = new Contact();
		contact.setId(id);
		contact = contactService.findById(contact);
		findById(email);
		email.setContact(contact);
		emailRepository.save(email);
	}
}
