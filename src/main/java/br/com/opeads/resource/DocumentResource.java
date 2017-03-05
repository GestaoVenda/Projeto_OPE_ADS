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

import br.com.opeads.model.Document;
import br.com.opeads.service.DocumentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class DocumentResource {

	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value = "/list/documento",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Document>> read(){
		return ResponseEntity.ok().body(documentService.read());
	}
	
	@RequestMapping(value = "/cliente/{id}/save/documento",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> createClientAddress(@PathVariable("id") Long id,@RequestBody Document address){
		address = documentService.createClientDocument(id, address);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/get/endereco/"+address.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> updateClientAddress(@PathVariable("id") Long id,@RequestBody Document address){
		documentService.updateClientDocument(id,address);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "cliente/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteClientAddress(@RequestBody Document address){
		documentService.delete(address);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/get/endereco/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Document> get(@PathVariable("id") Document address){
		address = documentService.findById(address);
		System.out.println(">>> "+address.getIdPerson().getId());
		return ResponseEntity.ok().body(address);
	}
	
	@RequestMapping(value = "/usuario/{id}/save/endereco",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> createUserAddress(@PathVariable("id") Long id,@RequestBody Document address){
		address = documentService.createUserDocument(id, address);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/get/endereco/"+address.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/edit/endereco",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> updateUserAddress(@PathVariable("id") Long id,@RequestBody Document address){
		documentService.updateUserDocument(id,address);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/delete/endereco",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteUserAddress(@RequestBody Document address){
		documentService.delete(address);
		return ResponseEntity.noContent().build() ;
	}
}
