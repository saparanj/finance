<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h4>Welcome to Add Fund Page</h4>
<form:form class="form-horizontal" action="processAddFund.form" method="post" modelAttribute="fund">
	<div class=	"error">${fund.errorMessage}</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Code(*)<br><form:errors path="fundCode" cssClass="error"/></span> 
		<form:input class="form-control" path="fundCode" type="text" maxlength="10"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Fund Name(*)<br><form:errors path="fundName" cssClass="error"/></span> 
		<form:input class="form-control" path="fundName" type="text" maxlength="50"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Code(*)<br><form:errors path="schemeCode" cssClass="error"/></span>
		<form:input class="form-control"  type="text" path="schemeCode" maxlength="10"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Name(*)<br><form:errors path="schemeName" cssClass="error"/></span>
		<form:input class="form-control"  type="text" path="schemeName" maxlength="50"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Category(*)<br><form:errors path="schemeCategory" cssClass="error"/></span>
		<form:select class="form-control"  path = "schemeCategory">
			<form:options items = "${schmeCategoryList}" />
		</form:select>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Scheme Mode(*)<br><form:errors path="schemeMode" cssClass="error"/></span>
		<form:select class="form-control"  path = "schemeMode">
			<form:options items = "${schmeModeList}" />
		</form:select>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Latest NAV(*)<br><form:errors path="latestNav" cssClass="error"/></span>
		<form:input class="form-control"  type="text" path="latestNav" maxlength="20"/>
	</div>
	<div class="input-group date" data-provide="datepicker">
		<span class="input-group-addon">Latest NAV Date(*)<br><form:errors path="latestNavDate" cssClass="error"/></span>
		<form:input type="text" class="form-control" path="latestNavDate" maxlength="12" readlonly="true"/>
		<div class="input-group-addon">
        	<span class="glyphicon glyphicon-th"></span>
    	</div>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Base NAV(*)<br><form:errors path="baseNav" cssClass="error"/></span>
		<form:input class="form-control"  type="text" path="baseNav" maxlength="20"/>
	</div>
	<div class="input-group">
		<span class="input-group-addon">Base Units(*)<br><form:errors path="baseUnits" cssClass="error"/></span>
		<form:input class="form-control"  type="text" path="baseUnits" maxlength="20"/>
	</div>
	<div class="input-group date" data-provide="datepicker">
		<span class="input-group-addon">Base NAV Date(*)<br><form:errors path="baseNavDate" cssClass="error"/></span>
		<form:input type="text" class="form-control" path="baseNavDate" maxlength="12" readlonly="true"/>
		<div class="input-group-addon">
        	<span class="glyphicon glyphicon-th"></span>
    	</div>
	</div>
	<div>
		<input type="submit" class="btn btn-primary" name = "loginButton" value="Save" />
	</div>
</form:form>

  <script>
  $(function(){
    $( "#baseNavDate" ).datepicker({
    		dateFormat: 'dd/mm/yy' 
    	}
    );
    $( "#latestNavDate" ).datepicker({
        		dateFormat: 'dd/mm/yy' 
        	}
        );
  });
  </script>