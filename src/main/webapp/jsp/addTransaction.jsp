<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>Welcome to Add Transaction Page</h3>
<form:form class="form-horizontal" action="processAddTransaction.form" method="post" modelAttribute="transactionForm">
	<br><div class=	"error">${fund.errorMessage}</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Code(*)<br><form:errors path="fundCode" cssClass="error"/></span> 
		<form:input class="form-control" path="fundCode" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Name(*)<br><form:errors path="fundName" cssClass="error"/></span> 
		<form:input class="form-control" path="fundName" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Code(*)<br><form:errors path="schemeCode" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeCode" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Name(*)<br><form:errors path="schemeName" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeName" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Category(*)<br><form:errors path="schemeCategory" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeCategory" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Mode(*)<br><form:errors path="schemeMode" cssClass="error"/></span> 
		<form:input class="form-control" path="schemeMode" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Folio Number (*)<br><form:errors path="folioNumber" cssClass="error"/></span> 
		<form:input class="form-control" path="folioNumber" type="text"  readonly="true"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Transaction Type(*)<br><form:errors path="transactionType" cssClass="error"/></span>
		<form:select class="form-control"  path = "transactionType">
			<form:options items = "${transactionTypeList}" />
		</form:select>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Transaction Date(*)<br><form:errors path="transactionDate" cssClass="error"/></span> 
		<form:input class="form-control" path="transactionDate" type="text"  readonly="true"/>
		<div class="input-group-addon">
        	<span class="glyphicon glyphicon-th"></span>
    	</div>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Transacted Units(*)<br><form:errors path="transactedUnits" cssClass="error"/></span> 
		<form:input class="form-control" path="transactedUnits" type="text"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Transaction NAV(*)<br><form:errors path="trasactedNav" cssClass="error"/></span> 
		<form:input class="form-control" path="trasactedNav" type="text"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Transaction Mode(*)<br><form:errors path="transactionMode" cssClass="error"/></span>
		<form:select class="form-control"  path = "transactionMode">
			<form:options items = "${transactionModeList}" />
		</form:select>
	</div>
	<div>
		<input type="submit"  class="btn btn-primary" name = "SaveTransactionButton" value="Save" />
	</div>


</form:form>
  <script>
  $(function(){
    $( "#transactionDate" ).datepicker({
    		dateFormat: 'dd/mm/yy' 
    	}
    );
   });
  </script>