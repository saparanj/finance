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
@Table(name="FOLIO_HOLDING")
public class FolioHoldings {
	
	@EmbeddedId
	private FolioId folioId; 

	@Column(name = "TOTAL_UNITS") 
	private double transactedUnits;
	
	@Column(name = "LAST_TRANSCTION_DATE") 
	@Temporal(TemporalType.DATE)
	private Date lastTransactioDate;

	@Column(name = "CREATE_DATE") 
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(name = "UPDATE_DATE")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;

	
	public FolioId getFolioId() {
		return folioId;
	}

	public void setFolioId(FolioId folioId) {
		this.folioId = folioId;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	
	
	
}