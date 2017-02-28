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

import br.com.opeads.model.Email;
import br.com.opeads.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmailResource {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/cliente/contato/list/email",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Email>> read(){
		return ResponseEntity.ok().body(emailService.read());
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/save/email",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id,@RequestBody Email email){
		email = emailService.create(id, email);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/contato/get/email"+email.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/edit/email",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Email email){
		emailService.update(id, email);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/delete/email",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Email email){
		emailService.delete(email);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/get/email/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Email> get(@PathVariable("id") Email email){
		return ResponseEntity.ok().body(emailService.findById(email));
	}
}
