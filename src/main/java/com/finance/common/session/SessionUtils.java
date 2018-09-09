package com.finance.common.session;

import java.util.Random;
import javax.servlet.http.HttpSession;
import com.finance.common.Constants;

public class SessionUtils {
	
	public static void setRandomKey(HttpSession session){
		String newRandomKey = null;
		Random random =  new Random();
        long nextRandNo = random.nextLong();
        newRandomKey = Long.toHexString(nextRandNo);
        String prevRandomKey = (String)SessionUtils.getSessionAttribute(session, Constants.RANDOM_KEY);
        setSessionAttribute(session, Constants.PREV_RANDOM_KEY, (String)SessionUtils.getSessionAttribute(session, Constants.RANDOM_KEY));
        setSessionAttribute(session, Constants.RANDOM_KEY, newRandomKey);
        System.out.println("Previous Random key="+prevRandomKey+"..new Random Key="+newRandomKey);
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
