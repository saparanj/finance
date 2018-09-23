package com.finance.form;

import javax.validation.constraints.NotNull;

public class TransactionSelectionForm {
	@NotNull(message=" Please Select A Transaction")
	private long transactionKey;
	private String errorMessage;
	
	public long getTransactionKey() {
		return transactionKey;
	}
	public void setTransactionKey(long transactionKey) {
		this.transactionKey = transactionKey;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
