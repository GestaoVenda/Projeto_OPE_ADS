package br.com.opeads.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.opeads.model.Person;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class UserService implements GenericInterfaceService<Person> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Person> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findById(Person e) {
		// TODO Auto-generated method stub
		return null;
	}

}
