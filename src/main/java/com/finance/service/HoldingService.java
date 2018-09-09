package com.finance.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.common.Utils;
import com.finance.dao.FolioDao;
import com.finance.dao.FundDao;
import com.finance.dao.HoldingDao;
import com.finance.entities.FolioHoldings;
import com.finance.entities.FolioId;
import com.finance.entities.FolioMaster;
import com.finance.entities.FundId;
import com.finance.entities.FundMaster;
import com.finance.processor.FundProcessor;
import com.finance.vo.HoldingVO;
import com.finance.vo.MutualFundFolioVO;

@Service
@Scope("prototype")
public class HoldingService extends GenericService{
	
	@Autowired
	private HoldingDao holdingDao;
	
	@Autowired
	private FolioDao folioDao;
	
	@Autowired
	private FundDao fundDao;
	
	public void setHoldingDao(HoldingDao holdingDao) {
		this.holdingDao = holdingDao;
	}

	
	public void setFolioDao(FolioDao folioDao) {
		this.folioDao = folioDao;
	}


	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}


	@Transactional
	public List<HoldingVO> fetchAllFunds() {
		List<HoldingVO> holdingList = new LinkedList();
		List<FolioHoldings>  holdings = holdingDao.fetchHoldings(getCurrentHibernateSession());
		HoldingVO vo = null;
		for(int i=0;i<holdings.size();i++) {
			FolioHoldings holding = (FolioHoldings)holdings.get(i);
			//vo = FundProcessor.mapFolioHoldingsToVO(holding);
			holdingList.add(vo);
		}
		return holdingList; 
	}

	@Transactional
	public List<HoldingVO> fetchAllFunds(String userId) {
		List<HoldingVO> holdingList = new LinkedList();
		List<FolioMaster> folioList = folioDao.fetchFoliosForUser(getCurrentHibernateSession(), userId);
		FolioId folioId = null;
		FundId fundId = null;
		HoldingVO vo = null;
		for(int i=0;i<folioList.size();i++) {
			FolioMaster folio = (FolioMaster)folioList.get(i);
			folioId = folio.getFolioId();
			fundId = FundProcessor.mapFundIdFromFolioId(folioId);
			FundMaster fund = fundDao.fetchFund(getCurrentHibernateSession(), fundId);
			FolioHoldings holding = holdingDao.fetchHolding(getCurrentHibernateSession(), folioId);
			if(holding!=null) {
				vo = FundProcessor.mapFolioHoldingsToVO(holding);
				vo.setUserId(userId);
				vo.setLastNAV(Utils.formatDouble_4(fund.getLatestNav()));
				vo.setLastNAVDate(fund.getLatestNavDate());
				vo.setBaseNAV(Utils.formatDouble_4(fund.getBaseNav()));
				vo.setBaseUnits(Utils.formatDouble_4(fund.getBaseUnits()));
				vo.setBaseNAVDate(fund.getBaseNavDate());
				vo.setCurrentAmout(Utils.formatDouble_2(vo.getTransactedUnits()*vo.getLastNAV()));
				holdingList.add(vo);
			}
		}
		return holdingList; 
	}
}
