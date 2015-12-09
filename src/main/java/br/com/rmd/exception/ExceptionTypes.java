package br.com.rmd.exception;

import br.com.rmd.messages.ValidationMessages;

public abstract class ExceptionTypes extends Exception{
	
	private static final long serialVersionUID = 1L;

	public abstract ValidationMessages getUserValidationMessages();
}
