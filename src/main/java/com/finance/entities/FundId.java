package com.finance.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 
@Embeddable
public class FundId implements Serializable {

	@Column(name = "FUND_CODE")
	protected String fundCode;
	@Column(name = "FUND_NAME")
	protected String fundName;
	@Column(name = "SCHEME_CODE")
	protected String schemeCode;
	@Column(name = "SCHEME_NAME")
	protected String schemeName;
	@Column(name = "SCHEME_CATEGORY") //Equity / Debt
	protected String schemeCategory;
	@Column(name = "SCHEME_MODE") // Direct / Regular
	protected String schemeMode;
	
	

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

	public FundId() {
		
	}
	
	public FundId(String fundCode,String fundName,String schemeCode,String schemeName,String schemeCategory,String schemeMode) {
		this.fundCode = fundCode;
		this.fundName = fundName;
		this.schemeCode = schemeCode;
		this.schemeName = schemeName;
		this.schemeCategory = schemeCategory;
		this.schemeMode = schemeMode;
	}
	
	 @Override
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof FundId)) return false;
	        FundId fundToCompare = (FundId) o;
	        return Objects.equals(getFundCode(), fundToCompare.getFundCode()) &&
	               Objects.equals(getFundName(),fundToCompare.getFundName()) &&
	               Objects.equals(getSchemeCode(),fundToCompare.getSchemeCode()) &&
	               Objects.equals(getSchemeName(),fundToCompare.getSchemeName()) &&
	               Objects.equals(getSchemeCategory(),fundToCompare.getSchemeCategory()) &&
	               Objects.equals(getSchemeMode(),fundToCompare.getSchemeMode());
	    }
	 
	 @Override
	 public int hashCode() {
		 return Objects.hash(getFundCode(),getFundName(),getSchemeCode(),getSchemeName(),getSchemeCategory(),getSchemeMode());
	 }
}
