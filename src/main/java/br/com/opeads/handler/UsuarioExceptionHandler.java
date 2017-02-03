package br.com.opeads.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.opeads.Exception.UsuarioJaExisteException;
import br.com.opeads.Exception.UsuarioNaoExisteException;
import br.com.opeads.error.model.Error;

@ControllerAdvice
public class UsuarioExceptionHandler {

	@ExceptionHandler(UsuarioNaoExisteException.class)
	public ResponseEntity<?> handlerUsuarioNaoExisteException(UsuarioNaoExisteException e,HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(204L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a não existência do dado informado");
		erro.setMessage("A requisição não obteve o retorno esperado. Para mais informações entre em contato com os desenvolvedores");
		erro.setError(new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UsuarioJaExisteException.class)
	public ResponseEntity<?> handlerUsuarioJaExisteException(UsuarioJaExisteException e, HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(409L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a já existência do dado informado, causando duplicidade");
		erro.setError(new Date());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
