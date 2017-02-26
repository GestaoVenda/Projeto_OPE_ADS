package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.CategoryAlreadyExistsException;
import br.com.opeads.exception.CategoryDoesNotExistsException;
import br.com.opeads.model.Category;
import br.com.opeads.repository.CategoryRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class CategoryService implements GenericInterfaceService<Category>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1176416519887255379L;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category create(Category category) {
		Category check = null;
		if(!category.getCategoryName().isEmpty())check = categoryRepository.findByCategoryName(category.getCategoryName());
		if(category.getId() != null)check = categoryRepository.findOne(category.getId());
		if(check != null)throw new CategoryAlreadyExistsException("A categoria informada já existe");
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> read() {
		return categoryRepository.findAll();
	}

	@Override
	public void delete(Category category) {
		findById(category);
		categoryRepository.delete(category);		
	}

	@Override
	public Category findById(Category category) {
		Category check = categoryRepository.findOne(category.getId());
		if(check == null)throw new CategoryDoesNotExistsException("A categoria informada não existe");;
		return check;
	}
	
	public void update(Category  category) {
		findById(category);
		categoryRepository.save(category);
	}

}
