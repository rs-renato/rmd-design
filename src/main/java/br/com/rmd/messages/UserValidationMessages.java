package br.com.rmd.messages;


public enum UserValidationMessages implements ValidationMessages{

	INVALID_LOGIN("The user login is invalid"),
	INVALID_PASSWORD("The password is invalid"),
	INVALID_BIRTHDATE("The birthdate is invalid");
	
	private String description;
	
	private UserValidationMessages(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
