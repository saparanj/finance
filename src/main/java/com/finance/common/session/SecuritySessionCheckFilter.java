package com.finance.common.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecuritySessionCheckFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		//System.out.println("SecuritySessionCheckFilter:init");
	}
	
	public void destroy() {
		//System.out.println("SecuritySessionCheckFilter:destroy");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		HttpSession session = httpRequest.getSession(false);
		String currentURL = httpRequest.getServletPath();
		//System.out.println("SecuritySessionCheckFilter:doFilter session="+session+"..currentURL="+currentURL);
		if(session!=null){
			SessionUtils.setRandomKey(session);
		}
		chain.doFilter(req, res);
	}

}
