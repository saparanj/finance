<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form class="form-horizontal" action="viewHoldings.form" method="post" modelAttribute="holdingInput">
	<h3>Search Holding for User</h3>
	<div class=	"error">${holdingInput.errorMessage}</div>
	<div class="input-group">
		<span class="input-group-addon"><strong>Folio Holder(*)</strong><br><form:errors path="folioHolder" cssClass="error"/></span> 
		<span class="input-group-addon">
			<form:input class="form-control" path="folioHolder" type="text"/>
		</span>
		<span class="input-group-addon">
        	<input type="submit" class="btn btn-primary" name = "SearchButton" value="Search" />
    	</span>
	</div>
</form:form>