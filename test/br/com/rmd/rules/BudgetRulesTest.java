package br.com.rmd.rules;

import java.util.Date;

import org.junit.Test;

import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.messages.BudgetValidationMessages;
import br.com.rmd.model.Budget;
import br.com.rmd.rules.BudgetRules;
import br.com.rmd.rules.invoker.RulesInvoker;

public class BudgetRulesTest extends RulesInvoker<BudgetRules, BudgetValidationMessages, Budget> {

	@Test
	public void testBudget(){
		
		Budget budget = new Budget();
		budget.setCreationDate(new Date());
		
		validate(BudgetRules.CREATION_DATE, budget);
		
		
		try {
			for (BudgetRules rules: BudgetRules.values()) {
				rules.validate(budget);
			}
		} catch (ExceptionTypes e) {
			System.out.println(e.getUserValidationMessages().getDescription());
		}
	}
}
