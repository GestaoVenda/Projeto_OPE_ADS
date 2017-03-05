package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.AddressAlreadyExistException;
import br.com.opeads.exception.AddressDoesNotExistException;
import br.com.opeads.model.Address;
import br.com.opeads.model.Person;
import br.com.opeads.repository.AddressRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class AddressService implements GenericInterfaceService<Address> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private Address checkAddress;

	@Override
	public List<Address> read() {
		return addressRepository.findAll();
	}

	//Here we save the Contact by relating it with the class Person
	public Address createClientAddress(Long id,Address address) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		verifyAddress(address);
		address.setIdPerson(client);
		return addressRepository.save(address);
	}

	public void updateClientAddress(Long id,Address address) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		findById(address);
		address.setIdPerson(client);
		addressRepository.save(address);
	}
	
	public Address createUserAddress(Long id,Address address) {
		Person user = new Person();
		user.setId(id);
		user = clientService.findById(user);
		verifyAddress(address);
		address.setIdPerson(user);
		return addressRepository.save(address);
	}

	public void updateUserAddress(Long id,Address address) {
		Person user = new Person();
		user.setId(id);
		user = clientService.findById(user);
		findById(address);
		address.setIdPerson(user);
		addressRepository.save(address);
	}

	@Override
	public void delete(Address address) {
		findById(address);
		addressRepository.delete(address);
	}

	@Override
	public Address findById(Address address) {
		checkAddress = null;
		try{
			checkAddress = addressRepository.findOne(address.getId());
		}catch(RuntimeException e){
			throw new AddressDoesNotExistException("O endereco informado não existe!");
		}
		if(checkAddress == null) throw new AddressDoesNotExistException("O endereco informado não existe!");
		return checkAddress;
	}
	
	private void verifyAddress(Address address){
		checkAddress = null;
		if(address.getId() != null)checkAddress = addressRepository.findOne(address.getId());
		if(checkAddress != null)throw new AddressAlreadyExistException("O endereço informado já existe!");
	}
}
