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

import br.com.opeads.model.Contact;
import br.com.opeads.service.ContactService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ContactResource {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/cliente/list/contato",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Contact>> read(){
		return ResponseEntity.ok().body(contactService.read());
	}
	
	@RequestMapping(value = "/cliente/{id}/save/contato",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id,@RequestBody Contact contact){
		contact = contactService.create(id, contact);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/get/contato/"+contact.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/contato",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody Contact contact){
		contactService.update(id,contact);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/delete/contato",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Contact contact){
		contactService.delete(contact);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/cliente/get/contato/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Contact> get(@PathVariable("id") Contact contact){
		return ResponseEntity.ok().body(contactService.findById(contact));
	}
}
