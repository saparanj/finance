package com.finance.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.common.TransactionType;
import com.finance.common.Utils;
import com.finance.dao.HoldingDao;
import com.finance.dao.TransactionDao;
import com.finance.entities.FolioHoldings;
import com.finance.entities.FolioId;
import com.finance.entities.FolioTransaction;
import com.finance.form.TransactionForm;
import com.finance.processor.FundProcessor;
import com.finance.vo.HoldingVO;
import com.finance.vo.MutualFundTransactionVO;

@Service
@Scope("prototype")
public class TransactionService extends GenericService {
	@Autowired
	HoldingDao holdingDao;
	@Autowired
	TransactionDao transactioDao;
	
	public TransactionService() {
		
	}

	public void setHoldingDao(HoldingDao holdingDao) {
		this.holdingDao = holdingDao;
	}

	public void setTransactioDao(TransactionDao transactioDao) {
		this.transactioDao = transactioDao;
	}
	
	@Transactional
	public List<MutualFundTransactionVO> fetchTransactionsForFolio(FolioId folioId) {
		//FolioId folioId = 
		List<MutualFundTransactionVO> transactionList = new LinkedList<MutualFundTransactionVO>();
		List<FolioTransaction> transactions = transactioDao.fetchTransactionsForFolio(getCurrentHibernateSession(), folioId);
		MutualFundTransactionVO vo = null;
		for(int i=0;i<transactions.size();i++) {
			FolioTransaction transaction = (FolioTransaction)transactions.get(i);
			vo =FundProcessor.mapFolioTransactionToVO(transaction);
			transactionList.add(vo);
		}
		return transactionList;
	}
	
	@Transactional
	public void addTransaction(MutualFundTransactionVO vo) {
		FolioId folioId = new FolioId();
		folioId.setFundCode(vo.getFundCode());
		folioId.setFundName(vo.getFundName());
		folioId.setSchemeCategory(vo.getSchemeCategory());
		folioId.setSchemeCode(vo.getSchemeCode());
		folioId.setSchemeMode(vo.getSchemeMode());
		folioId.setSchemeName(vo.getSchemeName());
		folioId.setFolioNumber(vo.getFolioNumber());
		
		FolioTransaction folioTransaction = new FolioTransaction();
		folioTransaction.setFolioNumber(vo.getFolioNumber());
		folioTransaction.setFundCode(vo.getFundCode());
		folioTransaction.setFundName(vo.getFundName());
		folioTransaction.setSchemeCategory(vo.getSchemeCategory());
		folioTransaction.setSchemeCode(vo.getSchemeCode());
		folioTransaction.setSchemeMode(vo.getSchemeMode());
		folioTransaction.setSchemeName(vo.getSchemeName());
		if(vo.getTransactionType().equals(TransactionType.PURCHASE.getValue()) ||
				vo.getTransactionType().equals(TransactionType.SI.getValue()) ||
				vo.getTransactionType().equals(TransactionType.SIP.getValue())){
			folioTransaction.setTransactedUnits(Utils.formatDouble_4(vo.getTransactedUnits()));
			folioTransaction.setTransactionAmount(Utils.formatDouble_2(vo.getTransactionAmount()));
		}else {
			folioTransaction.setTransactedUnits(Utils.formatDouble_4(vo.getTransactedUnits()*-1));
			folioTransaction.setTransactionAmount(Utils.formatDouble_2(vo.getTransactionAmount()*-1));
		}
		folioTransaction.setTransactionDate(vo.getTransactionDate());
		folioTransaction.setTrasactedNav(Utils.formatDouble_4(vo.getTrasactedNav()));
		folioTransaction.setTransactionMode(vo.getTransactionMode());
		folioTransaction.setTransactionType(vo.getTransactionType());
		folioTransaction.setCreateBy(vo.getCreateBy());
		folioTransaction.setCreateDate(vo.getCreateDate());
		
		FolioHoldings holding = null;
		holding = holdingDao.fetchHolding(getCurrentHibernateSession(), folioId);
		if(holding==null) {
			holding = new FolioHoldings();
			holding.setFolioId(folioId);
			holding.setCreateDate(folioTransaction.getCreateDate());
			holding.setTransactedUnits(Utils.formatDouble_4(folioTransaction.getTransactedUnits()));
			holding.setLastTransactioDate(folioTransaction.getTransactionDate());
			holding.setTotalAmount(Utils.formatDouble_2(folioTransaction.getTransactionAmount()));
		}else {
			holding.setTransactedUnits(Utils.formatDouble_4(holding.getTransactedUnits()+folioTransaction.getTransactedUnits()));
			holding.setUpdateDate(folioTransaction.getCreateDate());
			holding.setLastTransactioDate(folioTransaction.getTransactionDate());
			holding.setTotalAmount(Utils.formatDouble_2(holding.getTotalAmount()+folioTransaction.getTransactionAmount()));
		}
		transactioDao.saveFolioTransaction(getCurrentHibernateSession(), folioTransaction);
		holdingDao.saveOrUpdateFolioHoldings(getCurrentHibernateSession(), holding);
	}
}