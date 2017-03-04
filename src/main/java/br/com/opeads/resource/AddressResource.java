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

import br.com.opeads.model.Address;
import br.com.opeads.service.AddressService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AddressResource{
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/cliente/list/endereco",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Address>> read(){
		return ResponseEntity.ok().body(addressService.read());
	}
	
	@RequestMapping(value = "/cliente/{id}/save/endereco",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id,@RequestBody Address address){
		address = addressService.create(id, address);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/get/endereco/"+address).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody Address address){
		addressService.update(id,address);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "cliente/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Address address){
		addressService.delete(address);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/cliente/get/endereco/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Address> get(@PathVariable("id") Address address){
		return ResponseEntity.ok().body(addressService.findById(address));
	}

}
