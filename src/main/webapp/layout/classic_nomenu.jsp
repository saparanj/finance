<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
    <style type="text/css">
    	.error{color:red}
    </style>
  </head>
  <body>
        <table width="100%">
      <tr>
        <td align="center">
          <tiles:insertAttribute name="header" />
          <hr>
        </td>
      </tr>
      <tr>
        <td>
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      <tr>
        <td align="right">
          <hr>
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
    </table>
  </body>
</html>