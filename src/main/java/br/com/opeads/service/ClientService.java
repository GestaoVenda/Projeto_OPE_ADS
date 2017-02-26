package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.ClientAlreadyExistsException;
import br.com.opeads.exception.ClientDoesNotExistsException;
import br.com.opeads.model.Address;
import br.com.opeads.model.Client;
import br.com.opeads.model.Contact;
import br.com.opeads.repository.ClientRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ClientService implements GenericInterfaceService<Client>{

	private static final long serialVersionUID = -2564111722295953590L;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public List<Client> read() {
		return clientRepository.findAll();
	}

	//Here we save the client
	//After this, we call the service to save the @OneToMany Client attributes
	public Client create(Client client) {
		Client check = null;
		if(client.getId() != null)check = clientRepository.findOne(client.getId());
		if(client.getCnpj() != null)check = clientRepository.findByCnpj(client.getCnpj());
		if(client.getCpf() != null)check = clientRepository.findByCpf(client.getCpf());
		if(check != null)throw new ClientAlreadyExistsException("O cliente informado já existe");
		check = clientRepository.save(client);  
		for(Contact contact: client.getContacts()){
			contactService.create(check.getId(), contact);
		}
		for(Address address: client.getAddresses()){
			addressService.create(check.getId(), address);
		}
		return check ;
	}

	public void update(Client  client) {
		findById(client);
		clientRepository.save(client);
	}

	@Override
	public void delete(Client  client) {
		findById(client);
		clientRepository.delete(client);
	}

	@Override
	public Client findById(Client client) {
		Client check = clientRepository.findOne(client.getId());
		if(check == null)throw new ClientDoesNotExistsException("O cliente informado não existe");
		return check;
	}


}
