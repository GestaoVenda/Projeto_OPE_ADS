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

import br.com.opeads.model.Usuario;
import br.com.opeads.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/list/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar(){
		return ResponseEntity.ok().body(usuarioService.listar());
	}
	
	@RequestMapping(value = "/save/usuario",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Usuario usuario){
		usuario = usuarioService.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/usuario/"+usuario.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/edit/usuario",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@RequestBody Usuario usuario){
		usuarioService.alterar(usuario);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/delete/usuario",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Usuario usuario){
		usuarioService.remover(usuario);
		return ResponseEntity.noContent().build() ;
	}
}
