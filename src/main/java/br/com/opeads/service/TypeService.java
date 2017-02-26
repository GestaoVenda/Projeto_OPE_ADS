package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.opeads.exception.MenuAlreadyExistsException;
import br.com.opeads.exception.MenuDoesNotExistsException;
import br.com.opeads.model.Type;
import br.com.opeads.repository.TypeRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

public class TypeService implements GenericInterfaceService<Type>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367757779322568382L;
	
	
	@Autowired
	private TypeRepository typeRepository;
	
	public Type create(Type type) {
		Type check = null;
		if(type.getId() != null)check = typeRepository.findOne(type.getId());
		if(check != null)throw new MenuAlreadyExistsException("O tipo informado já existe");
		return typeRepository.save(type);
	}

	@Override
	public List<Type> read() {
		return typeRepository.findAll();
	}

	@Override
	public void delete(Type type) {
		findById(type);
		typeRepository.delete(type);
	}

	@Override
	public Type findById(Type type) {
		Type check = typeRepository.findOne(type.getId());
		if(check == null)throw new MenuDoesNotExistsException("O tipo informado não existe");
		return typeRepository.findOne(type.getId());
	}
	
	public void update(Type type) {
		findById(type);
		typeRepository.save(type);
	}
}
