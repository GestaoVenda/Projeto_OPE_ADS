package br.com.opeads.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opeads.service.ClienteService;

@RestController
@RequestMapping(value = "/API/Cliente", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

}
