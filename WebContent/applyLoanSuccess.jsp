<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Success</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat&display=swap');

.txt
{
position:absolute;
top:50%;
left:50%;
transform:translate(-50%,-50%);
font-family: 'Montserrat', sans-serif;
font-size: 30px;px;
color:white;
font-family: bold;
}
a:hover{
background-color: rgba(255,255,255,0.4);
color:black;

}
.bld{
text-transform: uppercase;
font-weight: bold;
color:#d42c2c;
font-style:italic;
font-family: inherit;
size: 30px;
}
.mail{
font-weight: bold;
color:#d42c2c;
font-style: italic;
size: 30px;
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
</style>
<body background="C:\Abc Programs\BankApplication\WebContent\loanverify.jpg" style="background-size: cover;">
<%
session=request.getSession();
out.println("<font class='txt'>"+"Dear,"+"<font class='bld'>"+session.getAttribute("name")+"</font>");
out.println("Thank you for showing interest for applying loan.");
out.println("Our Executive will Contact you soon.");
out.println("All the loan details are mailed to your mail-id: "+"<font class='mail'>"+session.getAttribute("email")+"</font>"+"</font>");
%>
<a href="Home.html">HOME</a>
</body>
</html>