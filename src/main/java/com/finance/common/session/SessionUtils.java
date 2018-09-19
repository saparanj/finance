package com.finance.common.session;

import java.util.Random;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.finance.common.Constants;

public class SessionUtils {
	
	private static Logger logger = LogManager.getLogger(SessionUtils.class);

	public static void setRandomKey(HttpSession session){
		logger.debug("Entering setRandomKey");
		String newRandomKey = null;
		Random random =  new Random();
        long nextRandNo = random.nextLong();
        newRandomKey = Long.toHexString(nextRandNo);
        String prevRandomKey = (String)SessionUtils.getSessionAttribute(session, Constants.RANDOM_KEY);
        setSessionAttribute(session, Constants.PREV_RANDOM_KEY, prevRandomKey);
        setSessionAttribute(session, Constants.RANDOM_KEY, newRandomKey);
		logger.debug("Exiting setRandomKey Previous Random key="+prevRandomKey+"..new Random Key="+newRandomKey);
 	}

	public static void setSessionAttribute(HttpSession session, String attributeName,Object attribute){
		session.setAttribute(attributeName, attribute);
	}
	
	public static Object getSessionAttribute(HttpSession session, String attributeName){
		return session.getAttribute(attributeName);
	}
	
	public static void removeAttribute(HttpSession session,String attributeName){
		session.removeAttribute(attributeName);
	}
	
}
