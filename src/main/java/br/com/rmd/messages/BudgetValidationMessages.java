package br.com.rmd.messages;

/**
 * Budget validation messages. This enum contais all messages wicth will
 * be thrown on budget validations.
 */
public enum BudgetValidationMessages implements ValidationMessages {
	
	INVALID_CREATION_DATE("The creation date is invalid"),
	INVALID_VALUE("The value is invalid"),
	EXPIRED("The budget is expired");

	private String description;

	BudgetValidationMessages(String description) {
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

}
