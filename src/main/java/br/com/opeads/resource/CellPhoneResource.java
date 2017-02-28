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

import br.com.opeads.model.CellPhone;
import br.com.opeads.service.CellPhoneService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CellPhoneResource {

	@Autowired
	private CellPhoneService cellPhoneService;
	
	@RequestMapping(value = "/cliente/contato/list/celular",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CellPhone>> read(){
		return ResponseEntity.ok().body(cellPhoneService.read());
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/save/celular",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@PathVariable("id") Long id,@RequestBody CellPhone cellPhone){
		cellPhone = cellPhoneService.create(id, cellPhone);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/cliente/contato/get/celular"+cellPhone.getId()).build().toUri();
		return ResponseEntity.created(uri).build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/{id}/edit/celular",method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody CellPhone cellPhone){
		cellPhoneService.update(id, cellPhone);
		return ResponseEntity.accepted().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/delete/celular",method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody CellPhone cellPhone){
		cellPhoneService.delete(cellPhone);
		return ResponseEntity.noContent().build() ;
	}
	
	@RequestMapping(value = "/cliente/contato/get/celular/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CellPhone> get(@PathVariable("id") CellPhone cellPhone){
		return ResponseEntity.ok().body(cellPhoneService.findById(cellPhone));
	}
}
