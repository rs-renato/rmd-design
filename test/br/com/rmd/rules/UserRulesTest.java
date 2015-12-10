package br.com.rmd.rules;

import br.com.rmd.invoker.RulesInvoker;
import br.com.rmd.messages.UserValidationMessages;
import br.com.rmd.model.User;
import org.junit.Test;

/**
 * Budget Rules Validation Test.
 * All rules container under test, must inherit {@link RulesInvoker} class,
 * informing {@link Rules}, {@link br.com.rmd.messages.ValidationMessages} and the Model under test.
 */
public class UserRulesTest extends RulesInvoker<UserRules, UserValidationMessages, User> {

    @Test
    public void testUserValid(){

        User user = new User();
        user.setLogin("juvenal");

        validate(UserRules.LOGIN, user);
    }

	@Test
	public void testInvalidUserLogin(){

		User user = new User();
		user.setLogin("ana");

		validateAndExpect(UserRules.LOGIN, UserValidationMessages.INVALID_LOGIN, user);
	}

}
