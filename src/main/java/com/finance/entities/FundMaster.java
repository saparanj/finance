package com.finance.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="FUND_MASTER")
public class FundMaster{
	
	@EmbeddedId
	private FundId fundId;
	
	@Column(name = "SCHEME_STATUS") // 1 Active / 0 Inactive
	private int schemeStatus = 1;
	
	@Column(name = "BASE_NAV") 
	private double baseNav;
	
	@Column(name = "NAV") 
	private double latestNav;
	
	@Column(name = "NAV_DATE") 
	@Temporal(TemporalType.DATE)
	private Date latestNavDate;
	
	@Column(name = "BASE_NAV_DATE") 
	@Temporal(TemporalType.DATE)
	private Date baseNavDate;
		
	@Column(name = "BASE_UNITS") 
	private double baseUnits;
	
	@Column(name = "CREATE_DATE") 
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name = "UPDATE_DATE") 
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name = "UPDATE_BY") 
	private String updatedBy;
	
	@Column(name = "CREATE_BY") 
	private String createdBy;
	
	public FundId getFundId() {
		return fundId;
	}
	public void setFundId(FundId fundId) {
		this.fundId = fundId;
	}
	public int getSchemeStatus() {
		return schemeStatus;
	}
	public void setSchemeStatus(int schemeStatus) {
		this.schemeStatus = schemeStatus;
	}
	public double getBaseNav() {
		return baseNav;
	}
	public void setBaseNav(double baseNav) {
		this.baseNav = baseNav;
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
	public Date getBaseNavDate() {
		return baseNavDate;
	}
	public void setBaseNavDate(Date baseNavDate) {
		this.baseNavDate = baseNavDate;
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
	public double getBaseUnits() {
		return baseUnits;
	}
	public void setBaseUnits(double baseUnits) {
		this.baseUnits = baseUnits;
	}
	
	
}
