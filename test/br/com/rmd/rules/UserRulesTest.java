package br.com.rmd.rules;

import org.junit.Test;

import br.com.rmd.messages.UserValidationMessages;
import br.com.rmd.model.User;
import br.com.rmd.rules.UserRules;
import br.com.rmd.rules.invoker.RulesInvoker;

public class UserRulesTest extends RulesInvoker<UserRules, UserValidationMessages, User> {

	@Test
	public void testUserException(){
		
		User user = new User();
		user.setLogin("r");
		
		validateAndExpect(UserRules.LOGIN, UserValidationMessages.INVALID_LOGIN, user);
	}
	
	@Test
	public void testUserValid(){
		
		User user = new User();
		user.setLogin("renato");
		
		validate(UserRules.LOGIN, user);
	}
	
}
