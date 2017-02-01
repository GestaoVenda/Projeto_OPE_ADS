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

import br.com.opeads.model.EnderecoUsuario;
import br.com.opeads.service.EnderecoUsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EnderecoUsuarioResource {

	@Autowired
	private EnderecoUsuarioService enderecoUsuarioService;
	
	@RequestMapping(value = "/usuario/list/endereco",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<EnderecoUsuario>> listar(){
		return ResponseEntity.ok().body(enderecoUsuarioService.listar());
	}
	
	@RequestMapping(value = "/usuario/{id}/save/endereco",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@PathVariable("id") Long id,@RequestBody EnderecoUsuario endereco){
		endereco = enderecoUsuarioService.inserir(id, endereco);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/usuario/"+endereco.getUsuario().getId()+"/find/endereco/"+endereco.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@PathVariable("id") Long id,@RequestBody EnderecoUsuario endereco){
		enderecoUsuarioService.alterar(id,endereco);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody EnderecoUsuario endereco){
		enderecoUsuarioService.remover(endereco);
		return ResponseEntity.noContent().build() ;
	}
}
