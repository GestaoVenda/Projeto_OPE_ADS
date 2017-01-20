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

import br.com.opeads.model.Endereco;
import br.com.opeads.service.EnderecoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EnderecoResource{
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(value = "/cliente/list/endereco",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Endereco>> listar(){
		return ResponseEntity.ok().body(enderecoService.listar());
	}
	
	@RequestMapping(value = "/cliente/{id}/save/endereco",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@PathVariable("id") Long id,@RequestBody Endereco endereco){
		endereco = enderecoService.inserir(id, endereco);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/"+endereco.getCliente().getId()+"/find/endereco/"+endereco.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@PathVariable("id") Long id,@RequestBody Endereco endereco){
		enderecoService.alterar(id,endereco);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "cliente/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Endereco endereco){
		enderecoService.remover(endereco);
		return ResponseEntity.noContent().build() ;
	}

}