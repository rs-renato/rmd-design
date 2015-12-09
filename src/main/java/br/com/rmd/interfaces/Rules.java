package br.com.rmd.interfaces;

import br.com.rmd.exception.ExceptionTypes;


public interface Rules <T> {
	abstract boolean validate(T t) throws ExceptionTypes;
}
