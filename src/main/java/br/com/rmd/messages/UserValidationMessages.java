package br.com.rmd.messages;

/**
 * User validation messages. This enum contais all messages wicth will
 * be thrown on user validations.
 */
public enum UserValidationMessages implements ValidationMessages{

	INVALID_LOGIN("The user login is invalid"),
	INVALID_PASSWORD("The password is invalid"),
	INVALID_BIRTHDATE("The birthdate is invalid");
	
	private String description;
	
	UserValidationMessages(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
