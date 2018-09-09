package com.finance.common;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URLUtils {
	public static String encodeURL(HttpSession session,HttpServletResponse response,String url){
		String encodedURL = null;
		String randomKey = null;
		StringBuffer stringBuffer = new StringBuffer(url);
		stringBuffer.append("?").append(Constants.RANDOM_KEY).append("=");
		
		try{
			randomKey =(String)session.getAttribute(Constants.RANDOM_KEY);
		}catch(Throwable t){
			//LoggingManager.error(LOGGER, commonParameters, Constants.APPLICATION_ID, Constants.MODULE_NAME, "IllegalStateException occured in encodeURL method of URLEncoder class,session already invalidated.");
		}
		
		if(randomKey!=null){
			stringBuffer.append(randomKey);
		}
		
		encodedURL = response.encodeURL(stringBuffer.toString());            
		
		return encodedURL;
	}
}