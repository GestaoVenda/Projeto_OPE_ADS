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

import br.com.opeads.model.Medida;
import br.com.opeads.service.MedidaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MedidaResource {

	@Autowired
	private MedidaService medidaService;
	
	@RequestMapping(value = "/list/medida")
	public ResponseEntity<List<Medida>> listar(){
		return ResponseEntity.ok().body(medidaService.listar());
	}
	
	@RequestMapping(value = "/save/medida", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Medida medida){
		medida = medidaService.inserir(medida);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/medida/"+medida.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/medida", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@RequestBody Medida medida){
		medidaService.alterar(medida);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/medida", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Medida medida){
		medidaService.remover(medida);
		return ResponseEntity.noContent().build();
	}
}
