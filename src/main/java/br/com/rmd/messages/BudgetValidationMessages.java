package br.com.rmd.messages;

public enum BudgetValidationMessages implements ValidationMessages {
	
	INVALID_CREATION_DATE("The creation date is invalid"),
	INVALID_VALUE("The value is invalid"),
	EXPIRED("The budget is expired");

	private String description;

	private BudgetValidationMessages(String description) {
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

}
