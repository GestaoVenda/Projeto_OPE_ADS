package br.com.opeads.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/Usuario", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
}
