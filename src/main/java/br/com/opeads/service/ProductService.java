package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.ProductAlreadyExistsException;
import br.com.opeads.Exception.ProductDoesNotExistsException;
import br.com.opeads.model.Product;
import br.com.opeads.repository.ProductRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ProductService implements GenericInterfaceService<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355847344019618836L;

	@Autowired
	private ProductRepository productRepository;
	
	public Product create(Product product) {
		Product check = null;
		if(product.getId() != null)check = productRepository.findOne(product.getId());
		if(check != null)throw new ProductAlreadyExistsException("O produto informado já existe");
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> read() {
		return productRepository.findAll();
	}

	@Override
	public void delete(Product product) {
		findById(product);
		productRepository.delete(product);	
	}

	@Override
	public Product findById(Product product) {
		Product check = productRepository.findOne(product.getId());
		if(check == null)throw new ProductDoesNotExistsException("O produto informado não existe");
		return productRepository.findOne(product.getId());
	}
	
	public void update(Product  product) {
		findById(product);
		productRepository.save(product);
	}

}
