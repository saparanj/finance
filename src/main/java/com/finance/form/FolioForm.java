package com.finance.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FolioForm {
	@NotNull(message=" is required")
	private String fundCode;
	@NotNull(message=" is required")
	private String fundName;
	@NotNull(message=" is required")
	private String schemeCode;
	@NotNull(message=" is required")
	private String schemeName;
	@NotNull(message=" is required")
	private String schemeCategory;
	@NotNull(message=" is required")
	private String schemeMode;
	@NotNull(message=" is required")
	@Size(min=1, max=50, message=" should be at least 1 characters and at the most 50 characters")
	private String folioNumber;

	@NotNull(message=" is required")
	@Size(min=1, max=10, message=" should be at least 1 characters and at the most 50 characters")
	private String folioHolder; // userid
	private String folioCanNumber; //CAN
	private String folioPanNumber; //Pan
	private String folioAadhaarNumber; //Aadhaar Number
	private String nominationStatus = "N"; //Y/N
	private String firstNominee;
	private String secondNominee;
	private double firstNomineePercentage;
	private double secondNomineePercentage;
	private Date createDate;
	private Date updateDate;
	private String updatedBy;
	private String createdBy;
	
	private String errorMessage;

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

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getFolioHolder() {
		return folioHolder;
	}

	public void setFolioHolder(String folioHolder) {
		this.folioHolder = folioHolder;
	}

	public String getFolioCanNumber() {
		return folioCanNumber;
	}

	public void setFolioCanNumber(String folioCanNumber) {
		this.folioCanNumber = folioCanNumber;
	}

	public String getFolioPanNumber() {
		return folioPanNumber;
	}

	public void setFolioPanNumber(String folioPanNumber) {
		this.folioPanNumber = folioPanNumber;
	}

	public String getFolioAadhaarNumber() {
		return folioAadhaarNumber;
	}

	public void setFolioAadhaarNumber(String folioAadhaarNumber) {
		this.folioAadhaarNumber = folioAadhaarNumber;
	}

	public String getNominationStatus() {
		return nominationStatus;
	}

	public void setNominationStatus(String nominationStatus) {
		this.nominationStatus = nominationStatus;
	}

	public String getFirstNominee() {
		return firstNominee;
	}

	public void setFirstNominee(String firstNominee) {
		this.firstNominee = firstNominee;
	}

	public String getSecondNominee() {
		return secondNominee;
	}

	public void setSecondNominee(String secondNominee) {
		this.secondNominee = secondNominee;
	}

	public double getFirstNomineePercentage() {
		return firstNomineePercentage;
	}

	public void setFirstNomineePercentage(double firstNomineePercentage) {
		this.firstNomineePercentage = firstNomineePercentage;
	}

	public double getSecondNomineePercentage() {
		return secondNomineePercentage;
	}

	public void setSecondNomineePercentage(double secondNomineePercentage) {
		this.secondNomineePercentage = secondNomineePercentage;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "FolioForm [fundCode=" + fundCode + ", fundName=" + fundName + ", schemeCode=" + schemeCode
				+ ", schemeName=" + schemeName + ", schemeCategory=" + schemeCategory + ", schemeMode=" + schemeMode
				+ ", folioNumber=" + folioNumber + ", folioHolder=" + folioHolder + ", folioCanNumber=" + folioCanNumber
				+ ", folioPanNumber=" + folioPanNumber + ", folioAadhaarNumber=" + folioAadhaarNumber
				+ ", nominationStatus=" + nominationStatus + ", firstNominee=" + firstNominee + ", secondNominee="
				+ secondNominee + ", firstNomineePercentage=" + firstNomineePercentage + ", secondNomineePercentage="
				+ secondNomineePercentage + ", createDate=" + createDate + ", updateDate=" + updateDate + ", updatedBy="
				+ updatedBy + ", createdBy=" + createdBy + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
