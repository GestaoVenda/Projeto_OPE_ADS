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
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/get/endereco/"+address.hashCode()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/edit/documento",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> updateClientAddress(@PathVariable("id") Long id,@RequestBody Document document){
		documentService.updateClientDocument(id,document);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/{id}/delete/documento",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteClientAddress(@RequestBody Document document){
		documentService.delete(document);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/get/documento/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Document> get(@PathVariable("id") Document document){
		return ResponseEntity.ok().body(documentService.findById(document));
	}
	
	@RequestMapping(value = "/usuario/{id}/save/documento",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> createUserAddress(@PathVariable("id") Long id,@RequestBody Document document){
		document = documentService.createUserDocument(id, document);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/usuario/get/endereco/"+document.hashCode()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/edit/documento",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> updateUserAddress(@PathVariable("id") Long id,@RequestBody Document document){
		documentService.updateUserDocument(id,document);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/usuario/{id}/delete/documento",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteUserAddress(@RequestBody Document document){
		documentService.delete(document);
		return ResponseEntity.noContent().build() ;
	}
}
