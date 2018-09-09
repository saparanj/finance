package com.finance.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.finance.entities.FolioId;

public class HoldingVO {
	
	private String userId;
	private String userCan;
	private String fundCode;
	private String fundName;
	private String schemeCode;
	private String schemeName;
	private String schemeCategory;
	private String schemeMode;
	private String folioNumber;
	private double transactedUnits;
	private Date lastTransactioDate;
	private Date createDate;
	private Date updateDate;
	private double totalAmount; //Cost
	private double lastNAV;
	private Date lastNAVDate;
	private double baseNAV;
	private Date baseNAVDate;
	private double baseUnits;
	
	private double currentAmout;
	private double profit;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCan() {
		return userCan;
	}
	public void setUserCan(String userCan) {
		this.userCan = userCan;
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
	public String getFolioNumber() {
		return folioNumber;
	}
	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}
	public double getTransactedUnits() {
		return transactedUnits;
	}
	public void setTransactedUnits(double transactedUnits) {
		this.transactedUnits = transactedUnits;
	}
	public Date getLastTransactioDate() {
		return lastTransactioDate;
	}
	public void setLastTransactioDate(Date lastTransactioDate) {
		this.lastTransactioDate = lastTransactioDate;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getLastNAV() {
		return lastNAV;
	}
	public void setLastNAV(double lastNAV) {
		this.lastNAV = lastNAV;
	}
	public Date getLastNAVDate() {
		return lastNAVDate;
	}
	public void setLastNAVDate(Date lastNAVDate) {
		this.lastNAVDate = lastNAVDate;
	}
	public double getBaseNAV() {
		return baseNAV;
	}
	public void setBaseNAV(double baseNAV) {
		this.baseNAV = baseNAV;
	}
	public Date getBaseNAVDate() {
		return baseNAVDate;
	}
	public void setBaseNAVDate(Date baseNAVDate) {
		this.baseNAVDate = baseNAVDate;
	}
	public double getBaseUnits() {
		return baseUnits;
	}
	public void setBaseUnits(double baseUnits) {
		this.baseUnits = baseUnits;
	}
	public double getCurrentAmout() {
		return currentAmout;
	}
	public void setCurrentAmout(double currentAmout) {
		this.currentAmout = currentAmout;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	

	
}
