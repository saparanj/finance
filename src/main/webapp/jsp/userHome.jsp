<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	Welcome ${sessionScope.SESSION_USER_KEY.userId}-${sessionScope.SESSION_USER_KEY.userName} 
	<br>
	  Random key set is <c:out value="${sessionScope.rKey}"/>
	<br>
	Your password is ${user.userpassword}
