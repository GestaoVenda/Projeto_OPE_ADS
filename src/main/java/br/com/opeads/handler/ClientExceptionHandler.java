package br.com.opeads.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.opeads.error.model.Error;
import br.com.opeads.exception.ClientAlreadyExistException;
import br.com.opeads.exception.ClientDoesNotExistException;

@ControllerAdvice
public class ClientExceptionHandler {

	@ExceptionHandler(ClientDoesNotExistException.class)
	public ResponseEntity<?> handlerClienteNaoExisteException(ClientDoesNotExistException e,HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(204L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a não existência do dado informado");
		erro.setMessage("A requisição não obteve o retorno esperado. Para mais informações entre em contato com os desenvolvedores");
		erro.setTimestamp(new Date());
		erro.setMessage(e.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ClientAlreadyExistException.class)
	public ResponseEntity<?> handlerClienteJaExisteException(ClientAlreadyExistException e, HttpServletRequest request){
		Error erro = new Error();
		erro.setStatus(409L);
		erro.setTitle(e.getMessage());
		erro.setDescription("Ocorreu um erro na requisição devido a já existência do dado informado, podendo causar duplicidade de dados");
		erro.setTimestamp(new Date());
		erro.setMessage("A requisição não obteve o retorno esperado. Para mais informações entre em contato com os desenvolvedores");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
