<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="com.finance.common.Constants,com.finance.common.URLUtils" %>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html> 
  <head>
    <title><tiles:getAsString name="title"/></title>
    <style type="text/css">
    	.error{color:red}
    </style>
    <style type="text/css">
    	.success{color:green}
    </style>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <!-- script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script-->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
  </head>
  <body align="center">
  <div class="container">
    <table cellspacing="5px" cellpadding="5px">
      <tr>
        <td colspan="2" align="center">
          <tiles:insertAttribute name="header" />
          <hr>
        </td>
      </tr>
      <tr>
      	<td colspan="2" aligh="right">
      	<span class="label label-default">${sessionScope.SESSION_USER_KEY.userName} (${sessionScope.SESSION_USER_KEY.userId})</span>
      	<span class="label label-default">CAN:- ${sessionScope.SESSION_USER_KEY.userCan}</span>
      	<span class="label label-default">PAN - ${sessionScope.SESSION_USER_KEY.userPan}</span>
      	</td>
      </tr>
      <tr>
      	<td colspan="2" aligh="right">&nbsp;</td>
      <tr>
      	<td colspan="2">
      	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">MF Folio Tracker</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Funds
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/viewFunds.form")%>">View Mutual Funds</a></li>
		          <li><a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/addFund.form")%>">Add Mutual Fund</a></li>
		        </ul>
		      </li>
		      <li>
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Folios
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/viewFolios.form")%>">View Folios</a></li>
		        </ul>
		      </li>
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Transactions
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/exportTransactionListExcel.form")%>">Export Transactions</a></li>
		        </ul>
		      </li>
		      <li><a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/viewHoldingInput.form")%>">View Holdings</a></li>
		      <li>
		      	<a href="${pageContext.request.contextPath}<%=URLUtils.encodeURL(session,response,"/logout.form")%>" class="btn">Logout</a>
          	  </li>
		    </ul>
		  </div>
      	</td>
      </tr>
      <tr>
        <td width="0%">
          <tiles:insertAttribute name="menu" />
        </td>
        <td width="100%">
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="right">
          <hr>
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>