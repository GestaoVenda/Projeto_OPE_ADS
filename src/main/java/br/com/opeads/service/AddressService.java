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
	private Address checkAddress;

	@Override
	public List<Address> read() {
		return addressRepository.findAll();
	}

	//Here we save the Contact by relating it with the class Person
	public Address create(Long id,Address address) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		verifyAddress(address);
		address.setIdPerson(client);
		return addressRepository.save(address);
	}

	public void update(Long id,Address address) {
		Person client = new Person();
		client.setId(id);
		client = clientService.findById(client);
		findById(address);
		address.setIdPerson(client);
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
		return checkAddress;
	}
	
	private void verifyAddress(Address address){
		checkAddress = null;
		if(address.getId() != null)checkAddress = addressRepository.findOne(address.getId());
		if(checkAddress != null)throw new AddressAlreadyExistException("O endereço informado já existe!");
	}
}
