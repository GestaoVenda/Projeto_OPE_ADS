package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Client;
import br.com.opeads.exception.AddressAlreadyExistsException;
import br.com.opeads.exception.ClientDoesNotExistsException;
import br.com.opeads.model.Address;
import br.com.opeads.repository.AddressRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class AddressService implements GenericInterfaceService<Address>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4470897900564721556L;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ClientService clientService;

	@Override
	public List<Address> read() {
		return addressRepository.findAll();
	}

	public Address create(Long id,Address address) {
		Client client = new Client();
		Address check = null;
		client.setId(id);
		client = clientService.findById(client);
		if(address.getId() != null)check = addressRepository.findOne(address.getId());
		if(check != null)throw new AddressAlreadyExistsException("O endereço informado já existe");
		address.setClient(client);
		return addressRepository.save(address);
	}

	public void update(Long id,Address address) {
		Client client = new Client();
		client.setId(id);
		client = clientService.findById(client);
		findById(address);
		address.setClient(client);
		addressRepository.save(address);
	}

	@Override
	public void delete(Address address) {
		findById(address);
		addressRepository.delete(address);
	}

	@Override
	public Address findById(Address address) {
		Address check = addressRepository.findOne(address.getId());
		if(check == null)throw new ClientDoesNotExistsException("O endereco informado não existe");
		return check;
	}

}
