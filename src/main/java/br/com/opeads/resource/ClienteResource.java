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

import br.com.opeads.model.Cliente;
import br.com.opeads.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/list/cliente",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.ok().body(clienteService.listar());
	}
	
	@RequestMapping(value = "/save/cliente",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Cliente cliente){
		cliente = clienteService.inserir(cliente);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/cliente/"+cliente.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/edit/cliente",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@RequestBody Cliente cliente){
		clienteService.alterar(cliente);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/delete/cliente",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Cliente cliente){
		clienteService.remover(cliente);
		return ResponseEntity.noContent().build() ;
	}

}
