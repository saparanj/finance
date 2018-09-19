package com.finance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FOLIO_MASTER")
public class FolioMaster {

	
	@EmbeddedId
	private FolioId folioId;
	
	@Column(name = "FOLIO_HOLDER") // Direct / Regular
	private String folioHolder; // userid

	@Column(name = "BASE_UNITS") 
	private double baseUnits;
	
	@Column(name = "BASE_NAV") 
	private double baseNav;
	
	@Column(name = "BASE_NAV_DATE") 
	@Temporal(TemporalType.DATE)
	private Date baseNavDate;
	
	@Column(name = "FOLIO_CAN_NUMBER") // Direct / Regular
	private String folioCanNumber; //CAN
	
	@Column(name = "FOLIO_PAN_NUMBER") // Direct / Regular
	private String folioPanNumber; //Pan
	
	@Column(name = "FOLIO_AADHAAR_NUMBER") // Direct / Regular
	private String folioAadhaarNumber; //Aadhaar Number
	
	@Column(name = "NOMIATION_STATUS") // Direct / Regular
	private String nominationStatus = "N"; //Y/N

	@Column(name = "FIRST_NOMINEE_NM") // Direct / Regular
	private String firstNominee;
	
	@Column(name = "SECOND_NOMINEE_NM") // Direct / Regular
	private String secondNominee;
	
	@Column(name = "FIRST_NOMINEE_PERCENTAGE") // Direct / Regular
	private double firstNomineePercentage;
	
	@Column(name = "SECOND_NOMINEE_PERCENTAGE") // Direct / Regular
	private double secondNomineePercentage;
	
	@Column(name = "CREATE_DATE") // Direct / Regular
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name = "UPDATE_DATE") // Direct / Regular
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name = "UPDATE_BY") // Direct / Regular
	private String updatedBy;
	
	@Column(name = "CREATE_BY") // Direct / Regular
	private String createdBy;

	public FolioId getFolioId() {
		return folioId;
	}

	public void setFolioId(FolioId folioId) {
		this.folioId = folioId;
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
