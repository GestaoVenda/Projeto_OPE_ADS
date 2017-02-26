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

import br.com.opeads.model.UserAddress;
import br.com.opeads.service.UserAddressService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserAddressResource {

	@Autowired
	private UserAddressService userAddressService;
	
	@RequestMapping(value = "/usuario/list/endereco",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<UserAddress>> read(){
		return ResponseEntity.ok().body(userAddressService.read());
	}
	
	@RequestMapping(value = "/usuario/{id}/save/endereco",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id, @RequestBody UserAddress userAddress){
		userAddress = userAddressService.create(id, userAddress);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/usuario/"+userAddress.getUser().getId()+"/find/endereco/"+userAddress.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody UserAddress userAddress){
		userAddressService.update(id,userAddress);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody UserAddress userAddress){
		userAddressService.delete(userAddress);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/usuario/get/endereco/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserAddress> get(@PathVariable("id") UserAddress userAddress){
		return ResponseEntity.ok().body(userAddressService.findById(userAddress));
	}
}
