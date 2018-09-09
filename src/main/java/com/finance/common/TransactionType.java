package com.finance.common;

public enum TransactionType {
	
	PURCHASE("PURCHASE"),
	SIP("SIP"),
	SI("SI"),
	REDEMPTION("REDEMPTION"),
	SO("SO");
	
	private String enumVal;
	
	TransactionType(String value){
		this.enumVal = value;
	}
	public String getValue() {

		return this.enumVal;
	}
	public static TransactionType getEnum(String val) {

		TransactionType[] array = values();
		TransactionType returnVal = null;
		for (TransactionType enm : array) {
			if (enm.enumVal.equals(val)) {
				returnVal = enm;
			}
		}

		return returnVal;
	}
	
	public String toString() {
		return this.getValue();
	}
}