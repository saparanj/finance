package com.finance.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint; 

@Component
@Aspect
public class FinanceLogger {
	   /** Following is the definition for a PointCut to select
	    *  all the methods available. So advice will be called
	    *  for all the methods.
	    */
	   @Pointcut("within(com.finance..*)")
	   private void selectAll(){}

	   /** 
	    * This is the method which I would like to execute
	    * around a selected method execution.
	    */
	   @Before("selectAll()")
	   public void beforeAdvice() throws Throwable{
	 //     System.out.println("Entering "+proceedingJoinPoint.getSignature());
/*	      Object[] args = proceedingJoinPoint.getArgs();
	      if(args.length>0){
	         System.out.print("Arguments passed: " );
	         for (int i = 0; i < args.length; i++) {
	            System.out.print("arg "+(i+1)+": "+args[i]);
	         }
	      }

	      Object result = proceedingJoinPoint.proceed(args);
	      System.out.println("Returning " + result);*/
	   }  
	   @After("selectAll()")
	   public void afterAdvice() throws Throwable{
		//   System.out.println("Existing "+ jp.getSignature());
	   }
}
