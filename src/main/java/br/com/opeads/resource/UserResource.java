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

import br.com.opeads.model.User;
import br.com.opeads.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<User>> read(){
		return ResponseEntity.ok().body(userService.read());
	}
	
	@RequestMapping(value = "/save/usuario",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@RequestBody User user){
		user = userService.create(user);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/usuario/"+user.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/edit/usuario",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@RequestBody User user){
		userService.update(user);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/delete/usuario",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody User user){
		userService.delete(user);
		return ResponseEntity.noContent().build() ;
	}
}
