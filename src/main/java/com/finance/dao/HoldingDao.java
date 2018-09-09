package com.finance.dao;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.finance.entities.FolioHoldings;
import com.finance.entities.FolioId;
import com.finance.entities.FolioMaster;

@Repository
@Scope("prototype")
public class HoldingDao {
	public void saveOrUpdateFolioHoldings(Session session, FolioHoldings folioHolding) {
		session.saveOrUpdate(folioHolding);
	}
	public FolioHoldings fetchHolding(Session session, FolioId folioId, boolean lock)  {
		LockMode lockMode = null;
		if(lock) {
			lockMode = LockMode.WRITE;
		}else {
			lockMode = LockMode.OPTIMISTIC;
		}
		FolioHoldings folioHoldings = session.get(FolioHoldings.class,folioId, lockMode);
		return folioHoldings;
	}

	public FolioHoldings fetchHolding(Session session, FolioId folioId)  {
		FolioHoldings folioHoldings = session.get(FolioHoldings.class,folioId);
		return folioHoldings;
	}
	
	public List<FolioHoldings> fetchHoldings(Session session) {
        Query q  = session.createQuery("from FolioHoldings", FolioHoldings.class);;
        List<FolioHoldings> holdingList = q.list();		
		return holdingList;
	}

}