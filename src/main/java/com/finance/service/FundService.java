package com.finance.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finance.common.Utils;
import com.finance.common.exception.BusinessException;
import com.finance.common.session.SessionUser;
import com.finance.dao.FundDao;
import com.finance.entities.AppUser;
import com.finance.entities.FundId;
import com.finance.entities.FundMaster;
import com.finance.processor.FundProcessor;
import com.finance.processor.UserProcessor;
import com.finance.vo.MutualFundVO;

@Service
@Scope("prototype")
public class FundService  extends GenericService {
	
	@Autowired
	private FundDao fundDao;
	
	public FundService() {
		super();
	}
	
	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	@Transactional
	public void addFund(MutualFundVO fundVO) throws BusinessException {
			
		FundId fundId = new FundId();
		fundId.setFundCode(fundVO.getFundCode());
		fundId.setFundName(fundVO.getFundName());
		fundId.setSchemeCategory(fundVO.getSchemeCategory());
		fundId.setSchemeCode(fundVO.getSchemeCode());
		fundId.setSchemeMode(fundVO.getSchemeMode());
		fundId.setSchemeName(fundVO.getSchemeName());

		FundMaster fundMaster = null;
		fundMaster = fundDao.fetchFund(getCurrentHibernateSession(), fundId);
		if(fundMaster!=null) {
			throw new BusinessException("Fund already Exists. Please use Update Link if you want to Update");
		}
		fundMaster = new FundMaster();
		fundMaster.setFundId(fundId);
		fundMaster.setBaseNav(Utils.formatDouble_4(fundVO.getBaseNav())); 
		fundMaster.setBaseUnits(Utils.formatDouble_4(fundVO.getBaseUnits()));
		fundMaster.setBaseNavDate(fundVO.getBaseNavDate());
		fundMaster.setLatestNav(Utils.formatDouble_4(fundVO.getLatestNav()));
		fundMaster.setLatestNavDate(fundVO.getLatestNavDate()); 
		fundMaster.setCreatedBy(fundVO.getCreateUserId());
		fundMaster.setCreateDate(fundVO.getCreateDate());
		fundDao.saveFund(getCurrentHibernateSession(), fundMaster);
	}

	@Transactional
	public FundMaster fetchFund(MutualFundVO fundVO, boolean lockMode) {
		FundId fundId = new FundId();
		fundId.setFundCode(fundVO.getFundCode());
		fundId.setFundName(fundVO.getFundName());
		fundId.setSchemeCategory(fundVO.getSchemeCategory());
		fundId.setSchemeCode(fundVO.getSchemeCode());
		fundId.setSchemeMode(fundVO.getSchemeMode());
		fundId.setSchemeName(fundVO.getSchemeName());

		FundMaster fundMaster = null;
		fundMaster = fundDao.fetchFund(getCurrentHibernateSession(), fundId, false);
		return fundMaster;
	}

	@Transactional
	public MutualFundVO fetchFund(MutualFundVO fundVO) {
		FundId fundId = new FundId();
		fundId.setFundCode(fundVO.getFundCode());
		fundId.setFundName(fundVO.getFundName());
		fundId.setSchemeCategory(fundVO.getSchemeCategory());
		fundId.setSchemeCode(fundVO.getSchemeCode());
		fundId.setSchemeMode(fundVO.getSchemeMode());
		fundId.setSchemeName(fundVO.getSchemeName());

		FundMaster fundMaster = null;
		fundMaster = fundDao.fetchFund(getCurrentHibernateSession(), fundId);
		MutualFundVO vo = FundProcessor.mapFundMasterToVO(fundMaster);
		return vo;
	}

	@Transactional
	public List<MutualFundVO> fetchAllFunds() {
		List<MutualFundVO> fundList = new LinkedList();
		List<FundMaster> funds = fundDao.fetchAllFunds(getCurrentHibernateSession());
		MutualFundVO vo = null;
		for(int i=0;i<funds.size();i++) {
			FundMaster fund = (FundMaster)funds.get(i);
			vo = FundProcessor.mapFundMasterToVO(fund);
			fundList.add(vo);
		}
		return fundList; 
	}

	@Transactional
	public void updateFund(MutualFundVO fundVO) throws BusinessException {
			
		FundId fundId = new FundId();
		fundId.setFundCode(fundVO.getFundCode());
		fundId.setFundName(fundVO.getFundName());
		fundId.setSchemeCategory(fundVO.getSchemeCategory());
		fundId.setSchemeCode(fundVO.getSchemeCode());
		fundId.setSchemeMode(fundVO.getSchemeMode());
		fundId.setSchemeName(fundVO.getSchemeName());

		FundMaster fundMaster = null;
		fundMaster = fundDao.fetchFund(getCurrentHibernateSession(), fundId);
		if(fundMaster==null) {
			throw new BusinessException("Fund does not exist");
		}
		fundMaster.setBaseNav(Utils.formatDouble_4(fundVO.getBaseNav())); 
		fundMaster.setBaseUnits(Utils.formatDouble_4(fundVO.getBaseUnits()));
		fundMaster.setBaseNavDate(fundVO.getBaseNavDate());
		fundMaster.setLatestNav(Utils.formatDouble_4(fundVO.getLatestNav()));
		fundMaster.setLatestNavDate(fundVO.getLatestNavDate()); 
		fundMaster.setUpdatedBy(fundVO.getUpdateUserId());
		fundMaster.setUpdateDate(fundVO.getUpdateDate());
		fundDao.saveFund(getCurrentHibernateSession(), fundMaster);
	}
	
	

}
