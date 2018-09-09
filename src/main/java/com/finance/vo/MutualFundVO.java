package com.finance.vo;

import java.util.Date;

public class MutualFundVO implements java.io.Serializable{
	
	private String fundCode;
	
	private String fundName;
	
	private String schemeCode;
	
	private String schemeName;
	
	private String schemeCategory;
	
	private String schemeMode;
	
	private double baseNav;
	
	private Date baseNavDate;
	
	private double baseUnits;
	
	private double latestNav;
	
	private Date latestNavDate;

	private String createUserId;
	
	private String updateUserId;
	
	private Date createDate;
	
	private Date updateDate;
	
	private String fundKey;
	

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

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
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
	
	public String getFundKey() {
		return fundKey;
	}

	public void setFundKey(String fundKey) {
		this.fundKey = fundKey;
	}
	
	

	public double getBaseUnits() {
		return baseUnits;
	}

	public void setBaseUnits(double baseUnits) {
		this.baseUnits = baseUnits;
	}

	@Override
	public String toString() {
		return "MutualFundVO [fundCode=" + fundCode + ", fundName=" + fundName + ", schemeCode=" + schemeCode
				+ ", schemeName=" + schemeName + ", schemeCategory=" + schemeCategory + ", schemeMode=" + schemeMode
				+ ", baseNav=" + baseNav + ", baseNavDate=" + baseNavDate + ", latestNav=" + latestNav
				+ ", latestNavDate=" + latestNavDate + ", createUserId=" + createUserId + ", updateUserId="
				+ updateUserId + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	
	
}
