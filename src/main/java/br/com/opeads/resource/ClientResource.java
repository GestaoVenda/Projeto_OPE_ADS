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

import br.com.opeads.model.Client;
import br.com.opeads.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/list/cliente",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Client>> read(){
		return ResponseEntity.ok().body(clientService.read());
	}
	
	@RequestMapping(value = "/save/cliente",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Client client){
		client = clientService.create(client);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/get/cliente/"+client.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/edit/cliente",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@RequestBody Client client){
		clientService.update(client);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/delete/cliente",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Client client){
		clientService.delete(client);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/get/cliente/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Client> getById(@PathVariable("id") Client client){
		return ResponseEntity.ok().body(clientService.findById(client));
	}
}
