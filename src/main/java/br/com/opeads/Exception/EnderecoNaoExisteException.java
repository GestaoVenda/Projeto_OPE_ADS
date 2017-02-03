package br.com.opeads.Exception;

public class EnderecoNaoExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489216955775105330L;
	
	public EnderecoNaoExisteException(String mensagem){
		super(mensagem);
	}

	public EnderecoNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
