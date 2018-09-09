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
import com.finance.entities.FolioTransaction;

@Repository
@Scope("prototype")
public class TransactionDao {
	public void saveFolioTransaction(Session session, FolioTransaction folioTransaction) {
		session.save(folioTransaction);
	}
	
	public List<FolioTransaction> fetchTransactionsForFolio(Session session,FolioId folioId) {
		Criteria cr = session.createCriteria(FolioTransaction.class);
		cr.add(Restrictions.eq("fundCode", folioId.getFundCode()));
		cr.add(Restrictions.eq("fundName", folioId.getFundName()));
		cr.add(Restrictions.eq("schemeCode", folioId.getSchemeCode()));
		cr.add(Restrictions.eq("schemeName", folioId.getSchemeName()));
		cr.add(Restrictions.eq("schemeCategory", folioId.getSchemeCategory()));
		cr.add(Restrictions.eq("schemeMode", folioId.getSchemeMode()));
		cr.add(Restrictions.eq("folioNumber", folioId.getFolioNumber()));
		cr.addOrder(Order.desc("transactionDate"));
		List<FolioTransaction> results = cr.list();
		return results;
	}
	public List<FolioTransaction> fetchAllTransactions(Session session) {
		Criteria cr = session.createCriteria(FolioTransaction.class);
		cr.addOrder(Order.asc("fundName"));
		cr.addOrder(Order.asc("schemeName"));
		cr.addOrder(Order.desc("schemeCategory"));
		cr.addOrder(Order.asc("schemeMode"));
		cr.addOrder(Order.asc("folioNumber"));
		cr.addOrder(Order.desc("transactionDate"));
		List<FolioTransaction> results = cr.list();
		return results;
	}
}
