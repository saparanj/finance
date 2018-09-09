<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h4>Welcome to Add Folio Page</h4>
<form:form class="form-horizontal" action="processAddFolio.form" method="post" modelAttribute="folioForm">
	<div class=	"error">${folioForm.errorMessage}</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Code(*)<br><form:errors path="fundCode" cssClass="error"/></span> 
		<form:input class="form-control" path="fundCode" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Name(*)<br><form:errors path="fundName" cssClass="error"/></span> 
		<form:input class="form-control" path="fundName" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Code(*)<br><form:errors path="schemeCode" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeCode" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Name(*)<br><form:errors path="schemeName" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeName" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Category(*)<br><form:errors path="schemeCategory" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeCategory" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Mode(*)<br><form:errors path="schemeMode" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeMode" type="text" maxlength="10" readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Folio Holder Id(*)<br><form:errors path="folioHolder" cssClass="error"/></span> 
		<form:input class="form-control" path="folioHolder" type="text" maxlength="10"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Folio Number(*)<br><form:errors path="folioNumber" cssClass="error"/></span> 
		<form:input class="form-control" path="folioNumber" type="text" maxlength="20"/>
	</div>
	<br>
	<div>
		<input type="submit"  class="btn btn-primary" name = "SaveFolioButton" value="Save" />
	</div>


</form:form>