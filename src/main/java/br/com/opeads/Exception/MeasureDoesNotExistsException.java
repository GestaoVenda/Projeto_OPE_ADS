package br.com.opeads.Exception;

public class MeasureDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3030819196321651104L;
	
	public MeasureDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public MeasureDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
