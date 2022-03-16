<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Employee delete form</h1>>
<form action="<%= request.getContextPath() %>/delete" method="post">
<table style="with: 80%">
<tr>
<td>Enter id: </td>
<td><input type="number" name="id"/></td>
</tr>
</table>
<input type="submit" value="submit"/>
</form>
</div>
</body>
</html>