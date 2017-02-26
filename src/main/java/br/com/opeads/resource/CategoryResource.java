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

import br.com.opeads.model.Category;
import br.com.opeads.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/list/categoria")
	public ResponseEntity<List<Category>> read(){
		return ResponseEntity.ok().body(categoryService.read());
	}
	
	@RequestMapping(value = "/save/categoria", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@RequestBody Category category){
		category = categoryService.create(category);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/categoria/"+category.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/categoria", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@RequestBody Category category){
		categoryService.update(category);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/categoria", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Category category){
		categoryService.delete(category);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/get/categoria")
	public ResponseEntity<Category> get(@PathVariable("id") Category category){
		return ResponseEntity.ok().body(categoryService.findById(category));
	}
}
