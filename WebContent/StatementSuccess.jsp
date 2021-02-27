<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement Success</title>
</head>
<body>
<%
session=request.getSession();
out.println("Reciever's Account Number-"+session.getAttribute("al1")+"<br><br>");
out.println("Amount in (INR)-"+session.getAttribute("al2")+"<br><br>");
out.println("Date and Time of Transaction-"+session.getAttribute("al3"));
%>
</body>
</html>