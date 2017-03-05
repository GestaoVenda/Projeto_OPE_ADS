package br.com.opeads.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.opeads.error.model.Error;
import br.com.opeads.exception.ContactAlreadyExistException;
import br.com.opeads.exception.ContactDoesNotExistException;

@ControllerAdvice
public class ContactExceptionHandler {

	@ExceptionHandler(ContactDoesNotExistException.class)
	public ResponseEntity<?> handlerContatoNaoExisteException(ContactDoesNotExistException e,HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(204L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a não existência do dado informado");
		erro.setMessage("A requisição não obteve o retorno esperado. Para mais informações entre em contato com os desenvolvedores");
		erro.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ContactAlreadyExistException.class)
	public ResponseEntity<?> handlerContatoJaExisteException(ContactAlreadyExistException e, HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(409L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a já existência do dado informado, causando duplicidade");
		erro.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
