package com.finance.common.session;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.finance.login.LoginForm;

public class SecuritySessionListner implements HttpSessionListener 

{

   public void sessionCreated(HttpSessionEvent sessionEvent){
	   HttpSession session = sessionEvent.getSession();
	   //System.out.println("####sessionCreated"+session);
	   if(session!=null){
		   //System.out.println("#### sessionId="+session.getId()+"####creationTime="+new java.util.Date()+"####lastAccessTime="+session.getLastAccessedTime()+"####Inactive Intterval="+session.getMaxInactiveInterval());
		   LoginForm user = (LoginForm)session.getAttribute("SESSION_USER");
		   //if(user!=null)
			   //System.out.println("#### userId="+user.getUserId());
	   }
	   // Called 
   }
 
  public void sessionDestroyed(HttpSessionEvent sessionEvent){
  /**
   *	This method will be called just before session is to be destroyed 
   */
	   HttpSession session = sessionEvent.getSession();
	   //System.out.println("****sessionDestroyed"+session);
	   if(session!=null){
		   //System.out.println("**** sessionId="+session.getId()+"****creationTime="+new java.util.Date()+"****lastAccessTime="+session.getLastAccessedTime()+"****Inactive Intterval="+session.getMaxInactiveInterval());
		   LoginForm user = (LoginForm)session.getAttribute("SESSION_USER");
		   //if(user!=null)
			   //System.out.println("**** userId="+user.getUserId());
	   }
  } 
  
  
  }


