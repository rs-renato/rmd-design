package br.com.rmd.exception;

import br.com.rmd.messages.ValidationMessages;

/**
 * Exception super class. All exception must extend this
 */
public abstract class ExceptionTypes extends Exception{
	
	private static final long serialVersionUID = 1L;

    /**
     * Return a user validation message
     * @return
     */
	public abstract ValidationMessages getUserValidationMessages();
}
