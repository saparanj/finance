package com.finance.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FolioId implements java.io.Serializable{
	
	@Column(name = "FUND_CODE")
	private String fundCode;
	@Column(name = "FUND_NAME")
	private String fundName;
	@Column(name = "SCHEME_CODE")
	private String schemeCode;
	@Column(name = "SCHEME_NAME")
	private String schemeName;
	@Column(name = "SCHEME_CATEGORY") //Equity / Debt
	private String schemeCategory;
	@Column(name = "SCHEME_MODE") // Direct / Regular
	private String schemeMode;
	@Column(name = "FOLIO_NUMBER")
	private String folioNumber;
	
	public FolioId() {
		
	}
	
	public FolioId(String fundCode,String fundName,String schemeCode,String schemeName,String schemeCategory,String schemeMode, String folioNumber) {
		this.fundCode = fundCode;
		this.fundName = fundName;
		this.schemeCode = schemeCode;
		this.schemeName = schemeName;
		this.schemeCategory = schemeCategory;
		this.schemeMode = schemeMode;
		this.folioNumber = folioNumber;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}
	
	
	
	 public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeCategory() {
		return schemeCategory;
	}

	public void setSchemeCategory(String schemeCategory) {
		this.schemeCategory = schemeCategory;
	}

	public String getSchemeMode() {
		return schemeMode;
	}

	public void setSchemeMode(String schemeMode) {
		this.schemeMode = schemeMode;
	}

	@Override
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof FundId)) return false;
	        FolioId fundToCompare = (FolioId) o;
	        return Objects.equals(getFundCode(), fundToCompare.getFundCode()) &&
	               Objects.equals(getFundName(),fundToCompare.getFundName()) &&
	               Objects.equals(getSchemeCode(),fundToCompare.getSchemeCode()) &&
	               Objects.equals(getSchemeName(),fundToCompare.getSchemeName()) &&
	               Objects.equals(getSchemeCategory(),fundToCompare.getSchemeCategory()) &&
	               Objects.equals(getSchemeMode(),fundToCompare.getSchemeMode()) &&
	               Objects.equals(getFolioNumber(),fundToCompare.getFolioNumber());
	    }
	 
	 @Override
	 public int hashCode() {
		 return Objects.hash(getFundCode(),getFundName(),getSchemeCode(),getSchemeName(),getSchemeCategory(),getSchemeMode(),getFolioNumber());
	 }
	


}
