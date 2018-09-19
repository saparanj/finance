package com.finance.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MutualFundFolioVO {
	private String fundCode;
	private String fundName;
	private String schemeCode;
	private String schemeName;
	private String schemeCategory;
	private String schemeMode;
	private String folioNumber;
	private String folioHolder; // userid
	private String folioCanNumber; //CAN
	private String folioPanNumber; //Pan
	private double baseNav;
	private Date baseNavDate;
	private double baseUnits;
	private String folioAadhaarNumber; //Aadhaar Number
	private String nominationStatus; //Y/N
	private String firstNominee;
	private String secondNominee;
	private double firstNomineePercentage;
	private double secondNomineePercentage;
	private Date createDate;
	private Date updateDate;
	private String updatedBy;
	private String createdBy;
	private String folioKey;
	
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
	public String getFolioKey() {
		return folioKey;
	}
	public void setFolioKey(String folioKey) {
		this.folioKey = folioKey;
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
	public double getBaseUnits() {
		return baseUnits;
	}
	public void setBaseUnits(double baseUnits) {
		this.baseUnits = baseUnits;
	}
}
