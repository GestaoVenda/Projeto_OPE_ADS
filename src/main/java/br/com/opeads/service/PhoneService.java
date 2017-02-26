package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.PhoneAlreadyExistsException;
import br.com.opeads.exception.PhoneDoesNotExistsException;
import br.com.opeads.model.Contact;
import br.com.opeads.model.Phone;
import br.com.opeads.repository.PhoneRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class PhoneService implements GenericInterfaceService<Phone>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1981059314998619313L;

	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private ContactService contactService;

	private Contact contact;
	
	public Phone create(Long id,Phone phone) {
		contact = null;
		Phone check = null;
		contact.setId(id);
		contact = contactService.findById(contact);
		if(phone.getId() != null)check = phoneRepository.findOne(phone.getId());
		if(check != null)throw new PhoneAlreadyExistsException("O telefone informado já existe");
		phone.setContact(contact);
		return phoneRepository.save(phone);
	}

	@Override
	public List<Phone> read() {
		return phoneRepository.findAll();
	}

	@Override
	public void delete(Phone Phone) {
		findById(Phone);
		phoneRepository.delete(Phone);
	}

	@Override
	public Phone findById(Phone Phone) {
		Phone check = phoneRepository.findOne(Phone.getId());
		if(check == null)throw new PhoneDoesNotExistsException("O telefone informado não existe");
		return phoneRepository.findOne(Phone.getId());
	}
	
}
