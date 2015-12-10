package br.com.rmd.exception;

import br.com.rmd.messages.UserValidationMessages;

/**
 * Excptions for user failed validations
 */
public class UserException extends ExceptionTypes{
	
	private static final long serialVersionUID = 1L;
	
	private UserValidationMessages userValidationMessages;

	public UserException(UserValidationMessages messages) {
		this.userValidationMessages = messages;
	}
	
	public UserValidationMessages getUserValidationMessages() {
		return userValidationMessages;
	}
}
