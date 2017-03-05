package br.com.opeads.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.opeads.error.model.Error;
import br.com.opeads.exception.AddressAlreadyExistException;
import br.com.opeads.exception.AddressDoesNotExistException;

@ControllerAdvice
public class AddressExceptionHandler {

	@ExceptionHandler(AddressDoesNotExistException.class)
	public ResponseEntity<?> handlerEnderecoNaoExisteException(AddressDoesNotExistException e,HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(204L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a não existência do dado informado");
		erro.setMessage("A requisição não obteve o retorno esperado. Para mais informações entre em contato com os desenvolvedores");
		erro.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AddressAlreadyExistException.class)
	public ResponseEntity<?> handlerEnderecoJaExisteException(AddressAlreadyExistException e, HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(409L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a já existência do dado informado, causando duplicidade");
		erro.setMessage("Houve um conflito de dados. Para mais informações entre em contato com os desenvolvedores");
		erro.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
