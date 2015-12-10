package br.com.rmd.rules;

import java.util.Calendar;

import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.exception.UserException;
import br.com.rmd.messages.UserValidationMessages;
import br.com.rmd.model.User;


/**
 * Rules for all user bussiness rules
 */
public enum UserRules implements Rules<User>{

	LOGIN{
		@Override
		public boolean validate(User user) throws ExceptionTypes {

            logger.info(".: Validation User login ...");
			
			if (user.getLogin().length() < 5) {
				throw new UserException(UserValidationMessages.INVALID_LOGIN);
			}

            logger.info(".: User login validated!");
			
			return true;
		}
	},
	
	PASSWORD{
		@Override
		public boolean validate(User user) throws ExceptionTypes {

            logger.info(".: Validating User password ...");

			if (user.getPassword().length() < 10) {
				throw new UserException(UserValidationMessages.INVALID_PASSWORD);
			}

            logger.info(".: User password validated!");

			return true;
		}
	},
	
	BIRTH_DATE{
		
		@Override
		public boolean validate(User user) throws ExceptionTypes {

            logger.info(".: User birthdate ...");

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -18);
			
			if ( cal.getTime().after(user.getBirthdate())) {
				throw new UserException(UserValidationMessages.INVALID_BIRTHDATE);
			}

            logger.info(".: User birthdate validated!");

			return true;
		}
	};
}
