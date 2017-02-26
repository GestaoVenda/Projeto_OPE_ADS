package br.com.opeads.exception;

public class CellPhoneDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7220555602286227994L;

	public CellPhoneDoesNotExistsException(String mensagem){
		super(mensagem);
	}

	public CellPhoneDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
