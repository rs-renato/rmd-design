package br.com.rmd.rules.invoker;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.interfaces.Rules;
import br.com.rmd.messages.ValidationMessages;



public abstract class RulesInvoker<R extends Rules<M>,
										V extends ValidationMessages,
										M>{

	protected void validateAndExpect(R rule, V validation, M model){
	
		try {
			
			rule.validate(model);
			fail(String.format("\"%s\" expected and not thrown!", validation.getDescription()));
			
		} catch (ExceptionTypes e) {
			assertTrue(validation.equals(e.getUserValidationMessages()));
		}
	}
	
	protected void validate(R rule, M model){
		
		try {
			assertTrue(rule.validate(model));
		} catch (ExceptionTypes e) {
			fail(String.format("\"%s\" not expected!", e.getUserValidationMessages().getDescription()));
		}
	}
}
