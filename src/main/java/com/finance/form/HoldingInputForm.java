package com.finance.form;

import javax.validation.constraints.NotNull;

public class HoldingInputForm {
	@NotNull(message=" is required")
	private String folioHolder;
	
	private String errorMessage;

	public String getFolioHolder() {
		return folioHolder;
	}

	public void setFolioHolder(String folioHolder) {
		this.folioHolder = folioHolder;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
