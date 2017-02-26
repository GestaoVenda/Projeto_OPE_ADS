package br.com.opeads.exception;


public class CellPhoneAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473241044252714871L;

	public CellPhoneAlreadyExistsException(String mensagem){
		super(mensagem);
	}

	public CellPhoneAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
