package br.com.rmd.rules;

import java.util.Calendar;

import br.com.rmd.exception.BudgetException;
import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.messages.BudgetValidationMessages;
import br.com.rmd.model.Budget;

/**
 * Rules for all budgets bussiness rules
 */
public enum BudgetRules implements Rules<Budget> {

	CREATION_DATE{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {

            logger.info(".: Validating budget creation date...");

            if (budget.getCreationDate() == null) {
				throw new BudgetException(BudgetValidationMessages.INVALID_CREATION_DATE);
			}

            logger.info(".: Budget creation date validated!");

			return true;
		}
	},
	
	VALUE{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {

            logger.info(".: Validating budget value ...");

			if (budget.getValue() <= 0) {
				throw new BudgetException(BudgetValidationMessages.INVALID_VALUE);
			}

            logger.info(".: Budget value validated!");

			return true;
		}
	},
	
	EXPIRED{
		
		@Override
		public boolean validate(Budget budget) throws ExceptionTypes {

            logger.info(".: Validation Budget expiration ...");
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(budget.getCreationDate());
			cal.add(Calendar.DATE, 2);
			
			if (cal.getTime().before(Calendar.getInstance().getTime())) {
				throw new BudgetException(BudgetValidationMessages.EXPIRED);
			}

            logger.info(".: Budget expiration validated!");

			return true;
		}
	}
}
