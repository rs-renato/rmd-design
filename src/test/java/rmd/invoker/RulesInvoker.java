package rmd.invoker;

import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.messages.ValidationMessages;
import br.com.rmd.rules.Rules;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Abstract class for rules validations
 * @param <R> {@link Rules} any rule
 * @param <V> {@link ValidationMessages} any validation
 * @param <M> any model under validation
 */
public abstract class RulesInvoker<R extends Rules<M>,
										V extends ValidationMessages,
										M>{

    protected Logger logger = Logger.getLogger(RulesInvoker.class);

    /**
     * Validate a rule and expect a validation message.
     * This test is used for negative validations witch
     * expect some thrown message validation.
     * @param rule rule under test
     * @param validation expected validation
     * @param model model under test
     */
	protected void validateAndExpect(R rule, V validation, M model){
	
		try {

            logger.info(".:: Validating rules. Expected message:'" + validation.getDescription() +"'");
			
			rule.validate(model);

            logger.error(String.format("Rule %s not validated!", rule));

            fail(String.format("'%s' expected and not thrown!", validation.getDescription()));

		} catch (ExceptionTypes e) {
			assertTrue(validation.equals(e.getUserValidationMessages()));
            logger.info(String.format(".:: Exception '%s' returned and expected! .::", e.getUserValidationMessages().getDescription()));
            logger.info(String.format("Rule %s successfully validated!", rule));
        }
	}

    /**
     * Validate a rule. This test is user for possitive validations
     * i.e, not expect any validation message to be thrown
     * @param rule rule under test
     * @param model model under test
     */
	protected void validate(R rule, M model){

        logger.info(".:: Validating rules with none expected message ::.");

		try {
			assertTrue(rule.validate(model));

            logger.info(String.format("Rule %s successfully validated!", rule));

		} catch (ExceptionTypes e) {
            logger.error(String.format(".:: Exception not expected thrown: %s", e.getUserValidationMessages().getDescription()));
            logger.error(String.format("Rule %s not validated!", rule));
        }
	}
}
