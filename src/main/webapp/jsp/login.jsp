<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="processLogin.form" method="post" modelAttribute="user">
	<div>
		User Name (*): <form:input path="userId" type="text" maxlength="10" value="saparanj"/>
		<form:errors path="userId" cssClass="error"/>
	</div>
	<br>
	<div>
		Password (*): <form:input type="password" path="userpassword" maxlength="20" value="saparanj"/>
		<form:errors path="userpassword" cssClass="error"/>
	</div>
	<br>
		<div class="error">${user.errorMessage}</div>
	<div>
		<input type="submit" name = "loginButton" value="Login" />
		<input type="button" name = ResetButton value="Reset" />
	</div>
</form:form>
