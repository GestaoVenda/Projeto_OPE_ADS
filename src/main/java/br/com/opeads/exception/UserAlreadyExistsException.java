package br.com.opeads.exception;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6945115150813748380L;

		
		public UserAlreadyExistsException(String mensagem){
			super(mensagem);
		}
		
		public UserAlreadyExistsException(String mensagem, Throwable causa){
			super(mensagem, causa);
		}
}
