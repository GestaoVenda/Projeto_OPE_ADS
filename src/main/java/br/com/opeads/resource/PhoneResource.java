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

import br.com.opeads.model.Phone;
import br.com.opeads.service.PhoneService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PhoneResource {

	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(value = "/cliente/contato/list/telefone",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Phone>> read(){
		return ResponseEntity.ok().body(phoneService.read());
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/save/telefone",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id,@RequestBody Phone phone){
		phone = phoneService.create(id, phone);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/contato/get/telefone"+phone.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/edit/telefone",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Phone phone){
		phoneService.update(id, phone);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/delete/telefone",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Phone phone){
		phoneService.delete(phone);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/get/telefone/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Phone> get(@PathVariable("id") Phone phone){
		return ResponseEntity.ok().body(phoneService.findById(phone));
	}
}
