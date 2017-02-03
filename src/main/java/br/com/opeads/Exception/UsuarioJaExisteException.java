package br.com.opeads.Exception;

public class UsuarioJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6945115150813748380L;

		
		public UsuarioJaExisteException(String mensagem){
			super(mensagem);
		}
		
		public UsuarioJaExisteException(String mensagem, Throwable causa){
			super(mensagem, causa);
		}
}
