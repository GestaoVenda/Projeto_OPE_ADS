package br.com.opeads.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.opeads.model.Categoria;
import br.com.opeads.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/list/categoria")
	public ResponseEntity<List<Categoria>> listar(){
		return ResponseEntity.ok().body(categoriaService.listar());
	}
	
	@RequestMapping(value = "/save/categoria", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Categoria categoria){
		categoria = categoriaService.inserir(categoria);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/categoria/"+categoria.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/categoria", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@RequestBody Categoria categoria){
		categoriaService.alterar(categoria);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/categoria", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Categoria categoria){
		categoriaService.remover(categoria);
		return ResponseEntity.noContent().build();
	}
}
