package com.finance.common.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.finance.common.Constants;
import com.finance.login.LoginForm;
import com.finance.service.LoginService;

public class SecuritySessionCheckFilter implements Filter {

	private static Logger logger = LogManager.getLogger(SecuritySessionCheckFilter.class);
	
	
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
		logger.debug("Entering doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		HttpSession session = httpRequest.getSession(false);
		String redirectURL = httpRequest.getScheme()+
				"://"+httpRequest.getServerName()+
				":"+
				httpRequest.getServerPort()+
				httpRequest.getContextPath();
		logger.debug("Request URI = ="+httpRequest.getRequestURI()+" session= "+session);
		if(!(httpRequest.getRequestURI().contains(Constants.LOGIN_URL)) && 
				!(httpRequest.getRequestURI().contains(Constants.LOGIN_SUBMIT_URL)) && 
						!(httpRequest.getRequestURI().contains(Constants.HOME_URL))) {
			if(session!=null){
				logger.debug("sessionId= "+session.getId());
				SessionUser userInSession= (SessionUser)session.getAttribute(Constants.SESSION_USER_KEY);
				 if(userInSession!=null) {
					SessionUtils.setRandomKey(session);
					logger.debug("user= "+userInSession.getUserId());
					logger.debug("Exiting doFilter");
					chain.doFilter(req, res);
				 }else {
					 HttpServletResponse httpResponse = (HttpServletResponse) res;
					 logger.debug("Exiting doFilter Redirecting to Homepage as userobject is not found");
					 httpResponse.sendRedirect(redirectURL);
				 }
			}else {
				 HttpServletResponse httpResponse = (HttpServletResponse) res;
				 logger.debug("Exiting doFilter Redirecting to Homepage session is null");
				 httpResponse.sendRedirect(redirectURL);
				
				}
		}else {
			logger.debug("Exiting doFilter");
			chain.doFilter(req, res);
		}
	}

}
