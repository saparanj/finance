package com.finance.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.common.exception.BusinessException;
import com.finance.dao.FolioDao;
import com.finance.dao.FundDao;
import com.finance.entities.FolioId;
import com.finance.entities.FolioMaster;
import com.finance.entities.FundId;
import com.finance.entities.FundMaster;
import com.finance.processor.FundProcessor;
import com.finance.vo.MutualFundFolioVO;
import com.finance.vo.MutualFundVO;

@Service
@Scope("prototype")
public class FolioService   extends GenericService {
	@Autowired
	private FolioDao folioDao;
	
	public FolioService() {
		super();
	}

	public void setFolioDao(FolioDao folioDao) {
		this.folioDao = folioDao;
	}
	
	@Transactional
	public MutualFundFolioVO fetchFolio(MutualFundFolioVO folioVO) throws BusinessException {
		MutualFundFolioVO vo = null;
		FolioId folioId = new FolioId();
		folioId.setFundCode(folioVO.getFundCode());
		folioId.setFundName(folioVO.getFundName());
		folioId.setSchemeCategory(folioVO.getSchemeCategory());
		folioId.setSchemeCode(folioVO.getSchemeCode());
		folioId.setSchemeMode(folioVO.getSchemeMode());
		folioId.setSchemeName(folioVO.getSchemeName());
		folioId.setFolioNumber(folioVO.getFolioNumber());
		FolioMaster folioMaster = null;
		folioMaster = folioDao.fetchFolio(getCurrentHibernateSession(), folioId);
		if(folioMaster!=null) {
			vo = FundProcessor.mapFolioMasterToVO(folioMaster);
		}else {
			throw new BusinessException("Folio does not Exist");
		}
		return vo;
	}
	
	@Transactional
	public void addFolio(MutualFundFolioVO folioVO) throws BusinessException {
			
		FolioId folioId = new FolioId();
		folioId.setFundCode(folioVO.getFundCode());
		folioId.setFundName(folioVO.getFundName());
		folioId.setSchemeCategory(folioVO.getSchemeCategory());
		folioId.setSchemeCode(folioVO.getSchemeCode());
		folioId.setSchemeMode(folioVO.getSchemeMode());
		folioId.setSchemeName(folioVO.getSchemeName());
		folioId.setFolioNumber(folioVO.getFolioNumber());
		

		FolioMaster folioMaster = null;
		folioMaster = folioDao.fetchFolio(getCurrentHibernateSession(), folioId);
		if(folioMaster!=null) {
			throw new BusinessException("Folio already Exists. Please use Update Link if you want to Update");
		}
		folioMaster = new FolioMaster();
		folioMaster.setFolioHolder(folioVO.getFolioHolder());
		folioMaster.setBaseNav(folioVO.getBaseNav());
		folioMaster.setBaseNavDate(folioVO.getBaseNavDate());
		folioMaster.setBaseUnits(folioVO.getBaseUnits());
		folioMaster.setFolioId(folioId);
		folioMaster.setCreatedBy(folioVO.getCreatedBy());
		folioMaster.setCreateDate(folioVO.getCreateDate());
		folioDao.saveFolio(getCurrentHibernateSession(), folioMaster);
	}
	
	@Transactional
	public void updateFolio(MutualFundFolioVO folioVO) throws BusinessException {
			
		FolioId folioId = new FolioId();
		folioId.setFundCode(folioVO.getFundCode());
		folioId.setFundName(folioVO.getFundName());
		folioId.setSchemeCategory(folioVO.getSchemeCategory());
		folioId.setSchemeCode(folioVO.getSchemeCode());
		folioId.setSchemeMode(folioVO.getSchemeMode());
		folioId.setSchemeName(folioVO.getSchemeName());
		folioId.setFolioNumber(folioVO.getFolioNumber());
		

		FolioMaster folioMaster = null;
		folioMaster = folioDao.fetchFolio(getCurrentHibernateSession(), folioId);
		if(folioMaster!=null) {
			folioMaster.setFolioHolder(folioVO.getFolioHolder());
			folioMaster.setBaseNav(folioVO.getBaseNav());
			folioMaster.setBaseNavDate(folioVO.getBaseNavDate());
			folioMaster.setBaseUnits(folioVO.getBaseUnits());
			folioMaster.setFolioId(folioId);
			folioMaster.setUpdateDate(new java.util.Date());
			folioMaster.setUpdatedBy(folioVO.getUpdatedBy());
			folioDao.saveFolio(getCurrentHibernateSession(), folioMaster);
		}else {
			throw new BusinessException("Folio does not Exist");
		}
	}

	
	@Transactional
	public List<MutualFundFolioVO> fetchAllFunds() {
		List<MutualFundFolioVO> folioList = new LinkedList();
		List<FolioMaster> folios = folioDao.fetchAllFolios(getCurrentHibernateSession());
		MutualFundFolioVO vo = null;
		for(int i=0;i<folios.size();i++) {
			FolioMaster folio = (FolioMaster)folios.get(i);
			vo = FundProcessor.mapFolioMasterToVO(folio);
			folioList.add(vo);
		}
		return folioList; 
	}


}
