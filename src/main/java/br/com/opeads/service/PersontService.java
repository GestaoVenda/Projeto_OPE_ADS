package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.PersonAlreadyExistsException;
import br.com.opeads.exception.PersonDoesNotExistsException;
import br.com.opeads.model.Address;
import br.com.opeads.model.Person;
import br.com.opeads.model.Contact;
import br.com.opeads.repository.ClientRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class PersontService implements GenericInterfaceService<Person>{

	private static final long serialVersionUID = -2564111722295953590L;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public List<Person> read() {
		return clientRepository.findAll();
	}

	//Here we save the client
	//After this, we call the service to save the @OneToMany Client attributes
	public Person create(Person client) {
		Person check = null;
		if(client.getId() != null)check = clientRepository.findOne(client.getId());
		if(client.getCnpj() != null)check = clientRepository.findByCnpj(client.getCnpj());
		if(client.getCpf() != null)check = clientRepository.findByCpf(client.getCpf());
		if(check != null)throw new PersonAlreadyExistsException("O cliente informado já existe");
		check = clientRepository.save(client);  
		for(Contact contact: client.getContacts()){
			contactService.create(check.getId(), contact);
		}
		for(Address address: client.getAddresses()){
			addressService.create(check.getId(), address);
		}
		return check ;
	}

	public void update(Person  client) {
		findById(client);
		clientRepository.save(client);
		for(Contact contact: client.getContacts()){
			contactService.update(client.getId(), contact);
		}
		for(Address address: client.getAddresses()){
			addressService.update(client.getId(), address);
		}
	}

	@Override
	public void delete(Person  client) {
		findById(client);
		clientRepository.delete(client);
	}

	@Override
	public Person findById(Person client) {
		Person check = clientRepository.findOne(client.getId());
		if(check == null)throw new PersonDoesNotExistsException("O cliente informado não existe");
		return check;
	}


}
