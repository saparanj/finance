package com.finance.form;

import javax.validation.constraints.NotNull; 

public class FolioSelection {
	
	@NotNull(message=" Please Select A Folio To Add Transaction")
	private String folioSelectionKey;
	private String errorMessage;
	public String getFolioSelectionKey() {
		return folioSelectionKey;
	}
	public void setFolioSelectionKey(String folioSelectionKey) {
		this.folioSelectionKey = folioSelectionKey;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
