<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>Search for Holdings</h3>
<form:form action="viewHoldings.form" method="post" modelAttribute="holdingInput">
<div class="input-group">
		<span class="input-group-addon"><strong>Folio Holder(*)</strong><br><form:errors path="folioHolder" cssClass="error"/></span> 
		<span class="input-group-addon">
			<form:input class="form-control" path="folioHolder" type="text"/>
		</span>
		<span class="input-group-addon">
        	<input type="submit" class="btn btn-primary" name = "SearchButton" id="searchButtonId" value="Search" />
        	<input type="submit" class="btn btn-primary" name = "ExportButton" id="exportButtonId" value="Export" />
    	</span>
	</div>
	<c:if test="${empty holdings}">
			<Table border="1" class="table table-striped">
			<tr>
				<th>Folio Number</th>
				<th>Fund Name</th>
				<th>Scheme Name</th>
				<th>Scheme Category</th>
				<th>Scheme Mode</th>
				<th>Units</th>
				<th>NAV</th>
				<th>Cost</th>
				<th>Current Amount</th>
				<th>Base Units</th>
				<th>Base NAV</th>
			</tr>
			<tr>
				<td colspan="11">No holdings and Transactions uploaded</td>
			</tr>
		</Table>
	</c:if>

	<c:if test="${not empty holdings}">
		<Table class="table table-striped">
			<tr>
				<th>Fund Name</th>
				<th>Scheme Name</th>
				<th>Folio Number</th>
				<th>Scheme Mode</th>
				<th>Scheme Category</th>
				<th>Units</th>
				<th>NAV</th>
				<th>Cost</th>
				<th>Current Amount</th>
				<th>Base Units</th>
				<th>Base NAV</th>
				<th>Base NAV Date</th>
			</tr>
			<c:forEach var="listValue" items="${holdings}">
			<tr>
				<td>${listValue.fundName}</td>
				<td>${listValue.schemeName}</td>
				<td>${listValue.folioNumber}</td>
				<td>${listValue.schemeMode}</td>
				<td>${listValue.schemeCategory}</td>
				<td>${listValue.transactedUnits}</td>
				<td>${listValue.lastNAV}</td>
				<td>${listValue.totalAmount}</td>
				<td>${listValue.currentAmout}</td>
				<td>${listValue.baseUnits}</td>
				<td>${listValue.baseNAV}</td>
				<td>${listValue.baseNAVDate}</td>
			</tr>
			</c:forEach>
		</Table>
	</c:if>
</form:form>

<script>
$(function(){
	$(".folioRadio").click(function(){
		//alert(this.value)
		$("#folioSelectionKey").val(this.value);
		$("#addTransactionButton").removeAttr("disabled");
		$("#viewTransactionsButton").removeAttr("disabled");
	});

	$("#searchButtonId").click(function(){
		$("#holdingInput").attr("action","viewHoldings.form");	
		$("#holdingInput").submit();
	});

	$("#exportButtonId").click(function(){
		$("#holdingInput").attr("action","exportHoldingListExcel.form");	
		$("#holdingInput").submit();
	});
});
</script>