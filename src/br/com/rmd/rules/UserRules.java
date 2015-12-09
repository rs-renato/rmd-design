package br.com.rmd.rules;

import java.util.Calendar;

import br.com.rmd.exception.ExceptionTypes;
import br.com.rmd.exception.UserException;
import br.com.rmd.interfaces.Rules;
import br.com.rmd.messages.UserValidationMessages;
import br.com.rmd.model.User;

public enum UserRules implements Rules<User>{

	LOGIN{
		@Override
		public boolean validate(User user) throws ExceptionTypes {
			
			if (user.getLogin().length() < 5) {
				throw new UserException(UserValidationMessages.INVALID_LOGIN);
			}
			
			return true;
		}
	},
	
	PASSWORD{
		@Override
		public boolean validate(User user) throws ExceptionTypes {
			
			if (user.getPassword().length() < 10) {
				throw new UserException(UserValidationMessages.INVALID_PASSWORD);
			}
			
			return true;
		}
	},
	
	BIRTH_DATE{
		
		@Override
		public boolean validate(User user) throws ExceptionTypes {
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -18);
			
			if ( cal.getTime().after(user.getBirthdate())) {
				throw new UserException(UserValidationMessages.INVALID_BIRTHDATE);
			}
			
			return true;
		}
	};
}
