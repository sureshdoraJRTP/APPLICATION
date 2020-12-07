<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b><font color="blue">${SuccessMsg}</font></b>
    <b><font color="red">${ErrorMsg}</font></b>
<form action="/ed" >
<input type="text" value="${infoDts.caseId}" name="caseId" >

<input type="submit" value="ED">
<form>
</body>
</html>