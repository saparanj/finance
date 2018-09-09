package com.finance.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MutualFundTransactionVO {
	private String fundCode;
	private String fundName;
	private String schemeCode;
	private String schemeName;
	private String schemeCategory;
	private String schemeMode;
	private String folioNumber;
	private String transactionType;
	private Date transactionDate;
	private double transactedUnits;
	private double trasactedNav;
	private String transactionMode; //MFU / ICICIDirect
	private double transactionAmount;
	private Date createDate;
	private Date updateDate;
	private String createBy;
	private String updateBy;
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getTransactedUnits() {
		return transactedUnits;
	}
	public void setTransactedUnits(double transactedUnits) {
		this.transactedUnits = transactedUnits;
	}
	public double getTrasactedNav() {
		return trasactedNav;
	}
	public void setTrasactedNav(double trasactedNav) {
		this.trasactedNav = trasactedNav;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	

}
