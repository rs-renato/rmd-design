package br.com.rmd.rules;

import br.com.rmd.invoker.RulesInvoker;
import br.com.rmd.messages.BudgetValidationMessages;
import br.com.rmd.model.Budget;
import org.junit.Test;

import java.util.Date;

/**
 * Budget Rules Validation Test.
 * All rules container under test, must inherit {@link RulesInvoker} class,
 * informing {@link Rules}, {@link br.com.rmd.messages.ValidationMessages} and the Model under test.
 */
public class BudgetRulesTest extends RulesInvoker<BudgetRules, BudgetValidationMessages, Budget> {

	@Test
	public void testBudget(){
		
		Budget budget = new Budget();
		budget.setCreationDate(new Date());
		
		validate(BudgetRules.CREATION_DATE, budget);
	}
}
