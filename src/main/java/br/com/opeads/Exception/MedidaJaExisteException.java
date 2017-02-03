package br.com.opeads.Exception;

public class MedidaJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621530566973949734L;

	public MedidaJaExisteException(String mensagem){
		super(mensagem);
	}
	
	public MedidaJaExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
