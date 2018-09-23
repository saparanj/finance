<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="addTransaction.form" method="post"  modelAttribute="transactionSelection">
	<c:if test="${not empty transactionList}">
		<c:forEach var="listValue" varStatus="theCount" items="${transactionList}">
			<c:if test="${theCount.isFirst()}">
				<Table class="table table-striped">
					<tr>
						<th>Fund Name</th>
						<th>Scheme Name</th>
						<th>Scheme Category</th>
						<th>Scheme Mode</th>
						<th>Folio Number</th>
					</tr>
					<tr>
						<td>${listValue.fundName}</td>
						<td>${listValue.schemeName}</td>
						<td>${listValue.schemeCategory}</td>
						<td>${listValue.schemeMode}</td>
						<td>${listValue.folioNumber}</td>
					</tr>
				</Table>
				<br>
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${not empty transactionList}">
		<Table class="table table-striped">
			<tr>
				<th>Transaction Date</th>
				<th>Transaction Type</th>
				<th>Transaction Units</th>
				<th>Transaction NAV</th>
				<th>Tranction Amount</th>
				<th>Transaction Mode</th>
				<th>Select</th>
			</tr>
			<c:forEach var="listValue" varStatus="theCount" items="${transactionList}">
			<tr>
				<td>${listValue.transactionDate}</td>
				<td>${listValue.transactionType}</td>
				<td>${listValue.transactedUnits}</td>
				<td>${listValue.trasactedNav}</td>
				<td>${listValue.transactionAmount}</td>
				<td>${listValue.transactionMode}</td>
				<td><input type="radio" class="transactionRadio" name = "transactionKey" value="${listValue.transactionId}" /></td>
			</tr>
			</c:forEach>
		</Table>
		
		<div align="center">
			<input type="submit"  class="btn btn-primary" disabled id="updateTransactionButton"  name = "updateTransactionButton" value="Update a Transaction" />
			<input type="submit"  class="btn btn-primary" disabled id="deleteTransactionButton"  name = "deleteTransactionButton" value="Delete a Transaction" />
		</div>
		
	</c:if>
</form:form>
<Script>
$(function(){
	$(".transactionRadio").click(function(){
		$("#updateTransactionButton").removeAttr("disabled");
		$("#deleteTransactionButton").removeAttr("disabled");
	});

	$("#updateTransactionButton").click(function(){
		$("#transactionSelection").attr("action","updateTransaction.form");	
		$("#transactionSelection").submit();
	});

	$("#deleteTransactionButton").click(function(){
		$("#transactionSelection").attr("action","deleteTransaction.form");	
		$("#transactionSelection").submit();
	});

});
</Script>