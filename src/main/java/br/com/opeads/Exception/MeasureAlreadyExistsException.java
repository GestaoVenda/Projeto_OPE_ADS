package br.com.opeads.Exception;

public class MeasureAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621530566973949734L;

	public MeasureAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public MeasureAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
