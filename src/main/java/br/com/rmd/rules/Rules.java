package br.com.rmd.rules;

import br.com.rmd.exception.ExceptionTypes;
import org.apache.log4j.Logger;

/**
 * Contract for rules validations
 * @param <T> parametrized T represents the model class under validation
 */
public interface Rules <T> {

	Logger logger = Logger.getLogger(Rules.class);

	/**
	 * Validates the model
	 * @param t model
	 * @return true if all validations are ok
	 * @throws ExceptionTypes throws a exception otherwise
	 */
	boolean validate(T t) throws ExceptionTypes;
}
