package com.finance.service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
@Service
@Scope("prototype")
public class GenericService {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public GenericService() {

	}
	
	public void initializeHibernateSession() {
		session = sessionFactory.getCurrentSession();
	}
	
	public Session getCurrentHibernateSession() {
		if(session==null) {
			initializeHibernateSession();
		}
		return session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	
}
