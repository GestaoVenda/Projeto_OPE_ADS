package br.com.opeads.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.opeads.model.Product;
import br.com.opeads.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/list/produto")
	public ResponseEntity<List<Product>> read(){
		return ResponseEntity.ok().body(productService.read());
	}
	
	@RequestMapping(value = "/save/produto", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@RequestBody Product product){
		product = productService.create(product);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/produto/"+product.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/produto", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@RequestBody Product product){
		productService.update(product);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/produto", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Product product){
		productService.delete(product);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/get/produto")
	public ResponseEntity<Product> get(@PathVariable("id") Product product){
		return ResponseEntity.ok().body(productService.findById(product));
	}
}
