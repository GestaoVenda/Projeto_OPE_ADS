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

import br.com.opeads.model.Measure;
import br.com.opeads.service.MeasureService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MeasureResource {

	@Autowired
	private MeasureService measureService;
	
	@RequestMapping(value = "/list/medida")
	public ResponseEntity<List<Measure>> read(){
		return ResponseEntity.ok().body(measureService.read());
	}
	
	@RequestMapping(value = "/save/medida", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@RequestBody Measure measure){
		measure = measureService.create(measure);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/medida/"+measure.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/medida", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> update(@RequestBody Measure measure){
		measureService.update(measure);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/medida", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> delete(@RequestBody Measure measure){
		measureService.delete(measure);
		return ResponseEntity.noContent().build();
	}
}
