package com.finance.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class FundForm {
	
	@NotNull(message=" is required")
	@Size(min=1, max=10, message=" should be at least 1 characters and at the most 10 characters")
	private String fundCode;
	
	@NotNull(message=" is required")
	@Size(min=1, max=50, message=" should be at least 1 characters and at the most 50 characters")
	private String fundName;
	
	@NotNull(message=" is required")
	@Size(min=1, max=10, message=" should be at least 1 characters and at the most 10 characters")
	private String schemeCode;
	
	@NotNull(message=" is required")
	@Size(min=1, max=100, message=" should be at least 1 characters and at the most 100 characters")
	private String schemeName;
	
	@NotNull(message=" is required")
	private String schemeCategory;
	
	@NotNull(message=" is required")
	private String schemeMode;
	
	@NotNull(message=" is required")
	private double baseNav;
	
	@NotNull(message=" is required")
	private Date baseNavDate;
	
	@NotNull(message=" is required")
	private double baseUnits;
	
	@NotNull(message=" is required")
	private double latestNav;
	
	@NotNull(message=" is required")
	private Date latestNavDate;
	
	
	private String createUserId;
	
	private Date createDate;
	

	private String updateUserId;
	
	private Date updateDate;
	
	private String errorMessage;
	
	private String successMessage;
	
	
	private String fundKey;
	

	public FundForm() {
		
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public double getBaseNav() {
		return baseNav;
	}

	public void setBaseNav(double baseNav) {
		this.baseNav = baseNav;
	}


	public Date getBaseNavDate() {
		return baseNavDate;
	}

	public void setBaseNavDate(Date baseNavDate) {
		this.baseNavDate = baseNavDate;
	}

	public double getLatestNav() {
		return latestNav;
	}

	public void setLatestNav(double latestNav) {
		this.latestNav = latestNav;
	}

	public Date getLatestNavDate() {
		return latestNavDate;
	}

	public void setLatestNavDate(Date latestNavDate) {
		this.latestNavDate = latestNavDate;
	}

	
	
	
	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	
	public String getFundKey() {
		return fundKey;
	}

	public void setFundKey(String fundKey) {
		this.fundKey = fundKey;
	}


	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public double getBaseUnits() {
		return baseUnits;
	}

	public void setBaseUnits(double baseUnits) {
		this.baseUnits = baseUnits;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	@Override
	public String toString() {
		return "FundForm [fundCode=" + fundCode + ", fundName=" + fundName + ", schemeCode=" + schemeCode
				+ ", schemeName=" + schemeName + ", schemeCategory=" + schemeCategory + ", schemeMode=" + schemeMode
				+ ", baseNav=" + baseNav + ", baseNavDate=" + baseNavDate + ", latestNav=" + latestNav
				+ ", latestNavDate=" + latestNavDate + ", createUserId=" + createUserId + ", createDate=" + createDate
				+ ", updateUserId=" + updateUserId + ", updateDate=" + updateDate + ", errorMessage=" + errorMessage
				+ "]";
	}


	
}
