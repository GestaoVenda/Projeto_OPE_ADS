package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.opeads.exception.MenuAlreadyExistsException;
import br.com.opeads.exception.MenuDoesNotExistsException;
import br.com.opeads.model.Menu;
import br.com.opeads.repository.MenuRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

public class MenuService implements GenericInterfaceService<Menu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9020258116480416982L;

	@Autowired
	private MenuRepository menuRepository;
	
	public Menu create(Menu menu) {
		Menu check = null;
		if(menu.getId() != null)check = menuRepository.findOne(menu.getId());
		if(check != null)throw new MenuAlreadyExistsException("O menu informado já existe");
		return menuRepository.save(menu);
	}

	@Override
	public List<Menu> read() {
		return menuRepository.findAll();
	}

	@Override
	public void delete(Menu menu) {
		findById(menu);
		menuRepository.delete(menu);
	}

	@Override
	public Menu findById(Menu menu) {
		Menu check = menuRepository.findOne(menu.getId());
		if(check == null)throw new MenuDoesNotExistsException("O menu informado não existe");
		return menuRepository.findOne(menu.getId());
	}
	
	public void update(Menu menu) {
		findById(menu);
		menuRepository.save(menu);
	}
}
