package com.finance.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.finance.entities.FolioId;
import com.finance.entities.FolioMaster;
@Repository
@Scope("prototype")
public class FolioDao {
	public void saveFolio(Session session, FolioMaster folioMaster) {
		session.save(folioMaster);
	}
	
	public FolioMaster fetchFolio(Session session, FolioId folioId, boolean lock)  {
		LockMode lockMode = null;
		if(lock) {
			lockMode = LockMode.WRITE;
		}else {
			lockMode = LockMode.OPTIMISTIC;
		}
		FolioMaster folioMaster = session.get(FolioMaster.class,folioId, lockMode);
		return folioMaster;
	}

	public FolioMaster fetchFolio(Session session, FolioId folioId)  {
		FolioMaster folioMaster = session.get(FolioMaster.class,folioId);
		return folioMaster;
	}
	
	public List<FolioMaster> fetchAllFolios(Session session) {
        Query q  = session.createQuery("from FolioMaster", FolioMaster.class);;
        List<FolioMaster> fundList = q.list();		
		return fundList;
	}

	public List<FolioMaster> fetchFoliosForUser(Session session,String userId){
		Criteria cr = session.createCriteria(FolioMaster.class);
		cr.add(Restrictions.eq("folioHolder", userId));
		cr.addOrder(Order.asc("folioId.fundName"));
		cr.addOrder(Order.asc("folioId.schemeName"));
		cr.addOrder(Order.asc("folioId.folioNumber"));
		cr.addOrder(Order.asc("folioId.schemeMode"));
		cr.addOrder(Order.asc("folioId.schemeCategory"));
		List results = cr.list();
		return results;
	}

}
