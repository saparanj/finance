package com.finance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="FOLIO_TRANSACTION")
public class FolioTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

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

	@Column(name = "TRANSACTION_TYPE") // SIP/SWP/RED/PUR/SO/SI
	private String transactionType;
	
	@Column(name = "TRANSACTION_DATE") 
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	
	@Column(name = "TRANSACTION_UNITS")
	private double transactedUnits;
	
	@Column(name = "TRANSACTION_NAV") 
	private double trasactedNav;
	
	@Column(name = "TRANSACTION_AMOUNT")
	private double transactionAmount;
	
	@Column(name = "TRANSACTION_MODE") 
	private String transactionMode; //MFU / ICICIDirect

	
	@Column(name = "CREATE_DATE") 
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name = "UPDATE_DATE") 
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "UPDATE_BY")
	private String updateBy;
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
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
	
	
	
}