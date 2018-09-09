package com.finance.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.finance.entities.FundId;
import com.finance.entities.FundMaster;

@Repository
@Scope("prototype")
public class FundDao {
	public void saveFund(Session session, FundMaster fundMaster) {
		session.save(fundMaster);
	}
	
	public FundMaster fetchFund(Session session, FundId fundId, boolean lock)  {
		LockMode lockMode = null;
		if(lock) {
			lockMode = LockMode.WRITE;
		}else {
			lockMode = LockMode.OPTIMISTIC;
		}
		FundMaster fundMaster = session.get(FundMaster.class,fundId, lockMode);
		return fundMaster;
	}

	public FundMaster fetchFund(Session session, FundId fundId)  {
		FundMaster fundMaster = session.get(FundMaster.class,fundId);
		return fundMaster;
	}
	
	public List<FundMaster> fetchAllFunds(Session session) {
        Query q  = session.createQuery("from FundMaster", FundMaster.class);;
        List<FundMaster> fundList = q.list();		
		return fundList;
	}


}
