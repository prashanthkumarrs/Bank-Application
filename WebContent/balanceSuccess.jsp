<%@page import="java.io.*,java.util.*,javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Success</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat&display=swap');
.bld{
text-transform: uppercase;
font-weight: bold;
color:#d42c2c;
font-style:italic;
font-family: inherit;
size: 30px;
}
a:hover{
background-color: rgba(255,255,255,0.4);
color:black;
}

a{
text-decoration: none;
color:white;
font-weight: bold;
position:absolute;
top:60%;
left:50%;
transform:translate(-50%,50%);
border:2px solid #fff;
padding: 10px 30px;
font-family: 'Montserrat', sans-serif;
color:#fff;
transition:1s ease;
text-decoration: none;
transition:0.6s ease;
border-radius: 8px;
}

.txt
{
position:absolute;
top:50%;
left:50%;
transform:translate(-50%,-50%);
font-family: 'Montserrat', sans-serif;
font-size: 30px;px;
color:white;
font-weight: bold;
}

</style>
<body background="C:\Abc Programs\BankApplication\WebContent\balance.jpg" style="background-size: cover;">
<%
Date dd=new Date();
session=request.getSession();
out.println("<font class='txt'>"+"Your  Balance as on "+"<font class='bld'>"+dd.toString()+"</font>"+" is Rs."+"<font class='bld'>"+session.getAttribute("balance")+"</font>"+" /-"+"</font>");
%>
<a href="Home.html">HOME</a>
</body>
</html>