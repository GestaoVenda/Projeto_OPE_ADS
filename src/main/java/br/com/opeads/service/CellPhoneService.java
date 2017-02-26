package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.CellPhoneAlreadyExistsException;
import br.com.opeads.exception.CellPhoneDoesNotExistsException;
import br.com.opeads.model.CellPhone;
import br.com.opeads.model.Contact;
import br.com.opeads.repository.CellPhoneRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class CellPhoneService implements GenericInterfaceService<CellPhone>{

private static final long serialVersionUID = 4682415633538544201L;
	
	@Autowired
	private CellPhoneRepository cellPhoneRepository;
	
	@Autowired
	private ContactService contactService;

	private Contact contact;
	
	public CellPhone create(Long id, CellPhone cellPhone) {
		CellPhone check = null;
		contact = null;
		contact.setId(id);
		contact = contactService.findById(contact);
		if(cellPhone.getId() != null)check = cellPhoneRepository.findOne(cellPhone.getId());
		if(check != null)throw new CellPhoneAlreadyExistsException("O celular informado já existe");
		cellPhone.setContact(contact);
		return cellPhoneRepository.save(cellPhone);
	}

	@Override
	public List<CellPhone> read() {
		return cellPhoneRepository.findAll();
	}

	@Override
	public void delete(CellPhone cellPhone) {
		findById(cellPhone);
		cellPhoneRepository.delete(cellPhone);
	}

	@Override
	public CellPhone findById(CellPhone cellPhone) {
		CellPhone check = cellPhoneRepository.findOne(cellPhone.getId());
		if(check == null)throw new CellPhoneDoesNotExistsException("O celular informado não existe");
		return cellPhoneRepository.findOne(cellPhone.getId());
	}
	

}
