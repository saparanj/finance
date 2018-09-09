package com.finance.form;

import javax.validation.constraints.NotNull;

public class FundSelection {
	
	@NotNull(message=" Please Select A fund To Add Folio")
	private String fundSelectionKey;
	
	private String errorMessage;

	public String getFundSelectionKey() {
		return fundSelectionKey;
	}

	public void setFundSelectionKey(String fundSelectionKey) {
		this.fundSelectionKey = fundSelectionKey;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
