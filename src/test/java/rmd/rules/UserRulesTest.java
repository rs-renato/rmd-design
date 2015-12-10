package rmd.rules;

import br.com.rmd.messages.UserValidationMessages;
import br.com.rmd.model.User;
import br.com.rmd.rules.Rules;
import br.com.rmd.rules.UserRules;
import org.junit.Test;
import rmd.invoker.RulesInvoker;

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
