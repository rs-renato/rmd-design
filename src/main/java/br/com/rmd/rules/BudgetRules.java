package br.com.rmd.rules;

import java.util.Calendar;

import br.com.rmd.exception.BudgetException;
import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.interfaces.Rules;
import br.com.rmd.messages.BudgetValidationMessages;
import br.com.rmd.model.Budget;

public enum BudgetRules implements Rules<Budget> {

	CREATION_DATE{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {
			
			if (budget.getCreationDate() == null) {
				throw new BudgetException(BudgetValidationMessages.INVALID_CREATION_DATE);
			}
			
			return true;
		}
	},
	
	VALUE{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {
			
			if (budget.getValue() <= 0) {
				throw new BudgetException(BudgetValidationMessages.INVALID_VALUE);
			}
			
			return true;
		}
	},
	
	EXPIRED{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(budget.getCreationDate());
			cal.add(Calendar.DATE, 2);
			
			if (cal.getTime().before(Calendar.getInstance().getTime())) {
				throw new BudgetException(BudgetValidationMessages.EXPIRED);
			}
			
			return true;
		}
	}
}
