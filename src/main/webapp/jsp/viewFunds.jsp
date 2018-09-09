<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="addFolio.form" method="post" modelAttribute="fundSelection">
	<c:if test="${not empty fundList}">

		<Table class="table table-striped">
			<tr>
				<th>Fund Name</th>
				<th>Scheme Name</th>
				<th>Scheme Category</th>
				<th>Scheme Mode</th>
				<th>Base NAV</th>
				<th>Base NAV Date</th>
				<th>Latest NAV</th>
				<th>Latest NAV Date</th>
				<th>Select</th>
			</tr>
			<c:forEach var="listValue" items="${fundList}">
			<tr>
				<td>${listValue.fundName}</td>
				<td>${listValue.schemeName}</td>
				<td>${listValue.schemeCategory}</td>
				<td>${listValue.schemeMode}</td>
				<td>${listValue.baseNav}</td>
				<td>${listValue.baseNavDate}</td>
				<td>${listValue.latestNav}</td>
				<td>${listValue.latestNavDate}</td>
				<td><input type="radio" class="fundRadio" name = "fundKey" value="${listValue.fundKey}" />	</td>
			</tr>
			</c:forEach>
		</Table>
		<br>
		<form:errors path="fundSelectionKey" cssClass="error"/>
		<br>
		<div class="error">${fundSelection.errorMessage}</div>
		<br>
		<div align="center">
			<input type="button" class="btn btn-primary" disabled name = "addFolioButton" id= "addFolioButton" value="Add Folio" />
			<input type="button" class="btn btn-primary" disabled name = "updateFundButton" id="updateFundButton" value="Update Fund" />
			<input type="button" class="btn btn-primary" disabled name = "deleteFundButton" id="deleteFundButton" value="Delete Fund" />
		</div>
		
	</c:if>
	
	<form:input path="fundSelectionKey" type="hidden"/>
</form:form>

<Script>
$(function(){
	$(".fundRadio").click(function(){
		//alert(this.value)
		$("#fundSelectionKey").val(this.value);
		$("#addFolioButton").removeAttr("disabled");
		$("#updateFundButton").removeAttr("disabled");
		$("#deleteFundButton").removeAttr("disabled");
	});

	$("#addFolioButton").click(function(){
		$("#fundSelection").attr("action","addFolio.form");	
		$("#fundSelection").submit();
	});

	
	$("#updateFundButton").click(function(){
		$("#fundSelection").attr("action","updateFund.form");	
		$("#fundSelection").submit();
	});
	$("#deleteFundButton").click(function(){
		$("#fundSelection").attr("action","deleteFolio.form");
		alert("Not yet Implemented")
		//$("#fundSelection").submit();
});
});
</Script>