package com.finance.common.exception;

@SuppressWarnings("serial")
public class BusinessException extends java.lang.Throwable{
	
	Throwable t;
	String exceptionMessage;
	
	public BusinessException() {
		t=this;
		this.exceptionMessage = t.getMessage();
	}
	
	public BusinessException(java.lang.Throwable t) {
		this.t = t;
		this.exceptionMessage = t.getMessage();
	}

	public BusinessException(java.lang.Exception e) {
		this.t = e;
		this.exceptionMessage = t.getMessage();
	}

	public BusinessException(String message) {
		t = new Exception(message);
		this.exceptionMessage = message;
	}

	public Throwable getT() {
		return t;
	}

	public void setT(Throwable t) {
		this.t = t;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "BusinessException [t=" + t + ", exceptionMessage=" + exceptionMessage + "]";
	}
	
}
