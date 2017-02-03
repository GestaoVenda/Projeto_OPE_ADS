package br.com.opeads.resource;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.opeads.auth.model.ResponseToken;
import br.com.opeads.model.Usuario;
import br.com.opeads.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/login")
public class AuthResource {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseToken> login(@RequestBody Usuario usuario) throws ServletException{
		usuario = usuarioService.autenticar(usuario);
		String token = Jwts.builder().setSubject(usuario.getNome()).signWith(SignatureAlgorithm.HS512, "wansan").setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
		return ResponseEntity.ok().body(new ResponseToken(token));
		
	}
	
}
