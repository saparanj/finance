package com.finance.processor;

import com.finance.entities.FolioHoldings;
import com.finance.entities.FolioId;
import com.finance.entities.FolioMaster;
import com.finance.entities.FolioTransaction;
import com.finance.entities.FundId;
import com.finance.entities.FundMaster;
import com.finance.form.FolioForm;
import com.finance.form.FolioSelection;
import com.finance.form.FundForm;
import com.finance.form.FundSelection;
import com.finance.form.TransactionForm;
import com.finance.vo.HoldingVO;
import com.finance.vo.MutualFundFolioVO;
import com.finance.vo.MutualFundTransactionVO;
import com.finance.vo.MutualFundVO;

public class FundProcessor {

	public static MutualFundVO mapFundToVO(FundForm fund) {
		MutualFundVO vo = new MutualFundVO();
		vo.setFundCode(fund.getFundCode());
		vo.setFundName(fund.getFundName());
		vo.setSchemeCategory(fund.getSchemeCategory());
		vo.setSchemeCode(fund.getSchemeCode());
		vo.setSchemeMode(fund.getSchemeMode());
		vo.setSchemeName(fund.getSchemeName());
		vo.setBaseNav(fund.getBaseNav());
		vo.setLatestNav(fund.getLatestNav());
		vo.setBaseNavDate(fund.getBaseNavDate());
		vo.setLatestNavDate(fund.getLatestNavDate());
		vo.setCreateUserId(fund.getCreateUserId());
		vo.setUpdateUserId(fund.getUpdateUserId());
		vo.setCreateDate(fund.getCreateDate());
		vo.setUpdateDate(fund.getUpdateDate()); 
		vo.setBaseUnits(fund.getBaseUnits());
		return vo;
	}

	public static MutualFundTransactionVO mapFolioTransactionToVO(FolioTransaction transaction) {
		MutualFundTransactionVO vo = new MutualFundTransactionVO();
		vo.setTransactionId(transaction.getTransactionId().longValue());
		vo.setFolioNumber(transaction.getFolioNumber());
		vo.setFundCode(transaction.getFundCode());
		vo.setFundName(transaction.getFundName());
		vo.setSchemeCategory(transaction.getSchemeCategory());
		vo.setSchemeCode(transaction.getSchemeCode());
		vo.setSchemeMode(transaction.getSchemeMode());
		vo.setSchemeName(transaction.getSchemeName());
		vo.setTransactionAmount(transaction.getTransactionAmount());
		vo.setTransactedUnits(transaction.getTransactedUnits());
		vo.setTransactionDate(transaction.getTransactionDate());
		vo.setTransactionType(transaction.getTransactionType());
		vo.setTransactionMode(transaction.getTransactionMode());
		vo.setTrasactedNav(transaction.getTrasactedNav());
		
		return vo;
	}

	
	public static MutualFundVO mapFundMasterToVO(FundMaster fund) {
		MutualFundVO vo = new MutualFundVO();
		vo.setFundCode(fund.getFundId().getFundCode());
		vo.setFundName(fund.getFundId().getFundName());
		vo.setSchemeCategory(fund.getFundId().getSchemeCategory());
		vo.setSchemeCode(fund.getFundId().getSchemeCode());
		vo.setSchemeMode(fund.getFundId().getSchemeMode());
		vo.setSchemeName(fund.getFundId().getSchemeName());
		vo.setBaseNav(fund.getBaseNav());
		vo.setBaseUnits(fund.getBaseUnits());
		vo.setLatestNav(fund.getLatestNav());
		vo.setBaseNavDate(fund.getBaseNavDate());
		vo.setLatestNavDate(fund.getLatestNavDate());
		vo.setCreateUserId(fund.getCreatedBy());
		vo.setUpdateUserId(fund.getUpdatedBy());
		vo.setCreateDate(fund.getCreateDate());
		vo.setUpdateDate(fund.getUpdateDate());
		String fundKey = new StringBuffer("")
				.append(fund.getFundId().getFundCode())
				.append("##")
				.append(fund.getFundId().getFundName())
				.append("##")
				.append(fund.getFundId().getSchemeCode())
				.append("##")
				.append(fund.getFundId().getSchemeName())
				.append("##")
				.append(fund.getFundId().getSchemeCategory())
				.append("##")
				.append(fund.getFundId().getSchemeMode()).toString();
		vo.setFundKey(fundKey);
		return vo;
	}

	public static MutualFundFolioVO mapFolioMasterToVO(FolioMaster folio) {
		MutualFundFolioVO vo = new MutualFundFolioVO();
		vo.setFolioNumber(folio.getFolioId().getFolioNumber());
		vo.setFundCode(folio.getFolioId().getFundCode());
		vo.setFundName(folio.getFolioId().getFundName());
		vo.setSchemeCategory(folio.getFolioId().getSchemeCategory());
		vo.setSchemeCode(folio.getFolioId().getSchemeCode());
		vo.setSchemeMode(folio.getFolioId().getSchemeMode());
		vo.setSchemeName(folio.getFolioId().getSchemeName());
		vo.setBaseNav(folio.getBaseNav());
		vo.setBaseNavDate(folio.getBaseNavDate());
		vo.setBaseUnits(folio.getBaseUnits());
		vo.setCreatedBy(folio.getCreatedBy());
		vo.setUpdatedBy(folio.getUpdatedBy());
		vo.setCreateDate(folio.getCreateDate());
		vo.setUpdateDate(folio.getUpdateDate());
		vo.setFolioHolder(folio.getFolioHolder());
		String folioKey = new StringBuffer("")
				.append(folio.getFolioId().getFundCode())
				.append("##")
				.append(folio.getFolioId().getFundName())
				.append("##")
				.append(folio.getFolioId().getSchemeCode())
				.append("##")
				.append(folio.getFolioId().getSchemeName())
				.append("##")
				.append(folio.getFolioId().getSchemeCategory())
				.append("##")
				.append(folio.getFolioId().getSchemeMode())
				.append("##")
				.append(folio.getFolioId().getFolioNumber()).toString();
		vo.setFolioKey(folioKey);
		return vo;
	}
	
	
	public static FolioForm mapFundSelectionToFolioForm(FundSelection funndSelectionForm) {
		String selectedFundKey = funndSelectionForm.getFundSelectionKey();
		String[] str = selectedFundKey.split("##");
		FolioForm folioForm = new FolioForm();
		folioForm.setFundCode(str[0]);
		folioForm.setFundName(str[1]);
		folioForm.setSchemeCode(str[2]);
		folioForm.setSchemeName(str[3]);
		folioForm.setSchemeCategory(str[4]);
		folioForm.setSchemeMode(str[5]);
		return folioForm;
		
	}

	public static FundForm mapFundSelectionToFundForm(FundSelection funndSelectionForm) {
		String selectedFundKey = funndSelectionForm.getFundSelectionKey();
		String[] str = selectedFundKey.split("##");
		FundForm fundForm = new FundForm();
		fundForm.setFundCode(str[0]);
		fundForm.setFundName(str[1]);
		fundForm.setSchemeCode(str[2]);
		fundForm.setSchemeName(str[3]);
		fundForm.setSchemeCategory(str[4]);
		fundForm.setSchemeMode(str[5]);
		return fundForm;
		
	}
	
	public static FolioForm mapFolioSelectionToFolioForm(FolioSelection form) {
		String selectedFundKey = form.getFolioSelectionKey();
		String[] str = selectedFundKey.split("##");
		FolioForm folioForm = new FolioForm();
		folioForm.setFundCode(str[0]);
		folioForm.setFundName(str[1]);
		folioForm.setSchemeCode(str[2]);
		folioForm.setSchemeName(str[3]);
		folioForm.setSchemeCategory(str[4]);
		folioForm.setSchemeMode(str[5]);
		folioForm.setFolioNumber(str[6]);
		return folioForm;
		
	}
	
	public static TransactionForm mapFolioSelectionToTransactionForm(FolioSelection form) {
		String selectedFundKey = form.getFolioSelectionKey();
		String[] str = selectedFundKey.split("##");
		TransactionForm transactionForm = new TransactionForm();
		transactionForm.setFundCode(str[0]);
		transactionForm.setFundName(str[1]);
		transactionForm.setSchemeCode(str[2]);
		transactionForm.setSchemeName(str[3]);
		transactionForm.setSchemeCategory(str[4]);
		transactionForm.setSchemeMode(str[5]);
		transactionForm.setFolioNumber(str[6]);
		return transactionForm;
		
	}
	
	public static FolioId mapTransactionFormToFolioId(TransactionForm form) {
		FolioId folioId = new FolioId();
		folioId.setFundCode(form.getFundCode());
		folioId.setFundName(form.getFundName());
		folioId.setSchemeCategory(form.getSchemeCategory());
		folioId.setSchemeCode(form.getSchemeCode());
		folioId.setSchemeMode(form.getSchemeMode());
		folioId.setSchemeName(form.getSchemeName());
		folioId.setFolioNumber(form.getFolioNumber());
		return folioId;
	}
	
	public static MutualFundFolioVO mapFundFolioToVO(FolioForm form) {
		MutualFundFolioVO vo = new MutualFundFolioVO();
		vo.setFundCode(form.getFundCode());
		vo.setFundName(form.getFundName());
		vo.setSchemeCategory(form.getSchemeCategory());
		vo.setSchemeCode(form.getSchemeCode());
		vo.setSchemeMode(form.getSchemeMode());
		vo.setSchemeName(form.getSchemeName());
		vo.setFolioNumber(form.getFolioNumber());
		vo.setCreatedBy(form.getCreatedBy());
		vo.setCreateDate(form.getCreateDate());
		vo.setFolioCanNumber(form.getFolioCanNumber());
		vo.setFolioPanNumber(form.getFolioPanNumber());
		vo.setFolioHolder(form.getFolioHolder());
		vo.setFolioAadhaarNumber(form.getFolioAadhaarNumber());
		vo.setBaseNav(form.getBaseNav());
		vo.setBaseNavDate(form.getBaseNavDate());
		vo.setBaseUnits(form.getBaseUnits());
		return vo;
	}
	
	public static FolioForm mapMutualFundVOToFolioForm(MutualFundFolioVO vo) {
		FolioForm form = new FolioForm();
		form.setFundCode(vo.getFundCode());
		form.setFundName(vo.getFundName());
		form.setSchemeCategory(vo.getSchemeCategory());
		form.setSchemeCode(vo.getSchemeCode());
		form.setSchemeMode(vo.getSchemeMode());
		form.setSchemeName(vo.getSchemeName());
		form.setFolioNumber(vo.getFolioNumber());
		form.setCreatedBy(vo.getCreatedBy());
		form.setCreateDate(vo.getCreateDate());
		form.setFolioCanNumber(vo.getFolioCanNumber());
		form.setFolioPanNumber(vo.getFolioPanNumber());
		form.setFolioHolder(vo.getFolioHolder());
		form.setFolioAadhaarNumber(vo.getFolioAadhaarNumber());
		form.setBaseNav(vo.getBaseNav());
		form.setBaseNavDate(vo.getBaseNavDate());
		form.setBaseUnits(vo.getBaseUnits());
		return form;
	}
	
	public static MutualFundTransactionVO mapFundTransactionToVO(TransactionForm form) {
		MutualFundTransactionVO vo = new MutualFundTransactionVO();
		vo.setFolioNumber(form.getFolioNumber());
		vo.setFundCode(form.getFundCode());
		vo.setFundName(form.getFundName());
		vo.setSchemeCategory(form.getSchemeCategory());
		vo.setSchemeCode(form.getSchemeCode());
		vo.setSchemeMode(form.getSchemeMode());
		vo.setSchemeName(form.getSchemeName());
		vo.setTransactedUnits(form.getTransactedUnits());
		vo.setTransactionDate(form.getTransactionDate());
		vo.setTransactionMode(form.getTransactionMode());
		vo.setTransactionType(form.getTransactionType());
		vo.setTrasactedNav(form.getTrasactedNav());
		vo.setTransactionAmount(vo.getTransactedUnits()*vo.getTrasactedNav());
		vo.setCreateBy(form.getCreateBy());
		vo.setCreateDate(form.getCreateDate());
		return vo;
	}
	
	public static HoldingVO mapFolioHoldingsToVO(FolioHoldings holding) {
		HoldingVO vo = new HoldingVO();
		vo.setFundCode(holding.getFolioId().getFundCode());
		vo.setFundName(holding.getFolioId().getFundName());
		vo.setSchemeCategory(holding.getFolioId().getSchemeCategory());
		vo.setSchemeCode(holding.getFolioId().getSchemeCode());
		vo.setSchemeMode(holding.getFolioId().getSchemeMode());
		vo.setSchemeName(holding.getFolioId().getSchemeName());
		vo.setFolioNumber(holding.getFolioId().getFolioNumber());
		vo.setTransactedUnits(holding.getTransactedUnits());
		vo.setLastTransactioDate(holding.getLastTransactioDate());
		vo.setTotalAmount(holding.getTotalAmount());
		return vo;
	}

	public static FundId mapFundIdFromFolioId(FolioId folioId) { 
		FundId fundId = new FundId();
		fundId.setFundCode(folioId.getFundCode());
		fundId.setFundName(folioId.getFundName());
		fundId.setSchemeCode(folioId.getSchemeCode());
		fundId.setSchemeCategory(folioId.getSchemeCategory());
		fundId.setSchemeMode(folioId.getSchemeMode());
		fundId.setSchemeName(folioId.getSchemeName());
		return fundId;
	}
}
