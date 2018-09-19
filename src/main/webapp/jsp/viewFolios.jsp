<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="addTransaction.form" method="post" modelAttribute="folioSelection">
	<c:if test="${not empty folioList}">

		<Table class="table table-striped">
			<tr>
				<th>Folio Number</th>
				<th>Fund Name</th>
				<th>Scheme Name</th>
				<th>Scheme Category</th>
				<th>Scheme Mode</th>
				<th>Select</th>
			</tr>
			<c:forEach var="listValue" items="${folioList}">
			<tr>
				<td>${listValue.folioNumber}</td>
				<td>${listValue.fundName}</td>
				<td>${listValue.schemeName}</td>
				<td>${listValue.schemeCategory}</td>
				<td>${listValue.schemeMode}</td>
				<td><input type="radio" class="folioRadio" name = "folioKey" value="${listValue.folioKey}" />	</td>
			</tr>
			</c:forEach>
		</Table>
		<br>
		<form:errors path="folioSelectionKey" cssClass="error"/>
		<br>
		<div align="center">
			<input type="submit"  class="btn btn-primary" disabled id="updateFolioButton"  name = "updateFolioButton" value="Update a Folio" />
			<input type="submit"  class="btn btn-primary" disabled id="addTransactionButton" name = "addFolioButton" value="Add Transacion for a Folio" />
			<input type="submit"  class="btn btn-primary" disabled id="viewTransactionsButton"  name = "viewTransactionsButton" value="View Transactions for a Folio" />
		</div>
		
	</c:if>
	
	<form:input path="folioSelectionKey" type="hidden"/>
</form:form>

<Script>
$(function(){
	$(".folioRadio").click(function(){
		//alert(this.value)
		$("#folioSelectionKey").val(this.value);
		$("#addTransactionButton").removeAttr("disabled");
		$("#viewTransactionsButton").removeAttr("disabled");
		$("#updateFolioButton").removeAttr("disabled");
	});

	$("#addTransactionButton").click(function(){
		$("#folioSelection").attr("action","addTransaction.form");	
		$("#folioSelection").submit();
	});

	$("#viewTransactionsButton").click(function(){
		$("#folioSelection").attr("action","viewTransaction.form");	
		$("#folioSelection").submit();
	});

	$("#updateFolioButton").click(function(){
		$("#folioSelection").attr("action","updateFolio.form");	
		$("#folioSelection").submit();
	});
	

});
</Script>