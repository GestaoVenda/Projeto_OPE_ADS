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

import br.com.opeads.model.Contato;
import br.com.opeads.service.ContatoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping(value = "/cliente/list/contato",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Contato>> listar(){
		return ResponseEntity.ok().body(contatoService.listar());
	}
	
	@RequestMapping(value = "/cliente/{id}/save/contato",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@PathVariable("id") Long id,@RequestBody Contato contato){
		contato = contatoService.inserir(id, contato);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/"+contato.getCliente().getId()+"/find/contato/"+contato.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/contato",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@PathVariable("id") Long id,@RequestBody Contato contato){
		contatoService.alterar(id,contato);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/delete/contato",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Contato contato){
		contatoService.remover(contato);
		return ResponseEntity.noContent().build() ;
	}
}
