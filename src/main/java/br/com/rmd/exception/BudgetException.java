package br.com.rmd.exception;

import br.com.rmd.messages.BudgetValidationMessages;
import br.com.rmd.messages.ValidationMessages;

/**
 * Excptions for budgets failed validations
 */
public class BudgetException extends ExceptionTypes {

	private static final long serialVersionUID = 1L;
	
	private BudgetValidationMessages budgetValidationMessages;

	public BudgetException(BudgetValidationMessages budgetValidationMessages) {
		this.budgetValidationMessages = budgetValidationMessages;
	}
	
	@Override
	public ValidationMessages getUserValidationMessages() {
		return budgetValidationMessages;
	}

}
