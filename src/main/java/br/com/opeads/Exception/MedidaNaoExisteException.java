package br.com.opeads.Exception;

public class MedidaNaoExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3030819196321651104L;
	
	public MedidaNaoExisteException(String mensagem){
		super(mensagem);
	}
	
	public MedidaNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
