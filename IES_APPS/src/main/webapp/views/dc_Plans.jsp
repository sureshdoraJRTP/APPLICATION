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
<h1 align="center">
	<form:form action="Saveplans" method="post" modelAttribute="dc">
		<table>
			<tr>
				<td>Case Id</td>
				<td><input type="text" value="${CaseDtls.caseId}" name="caseId"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" value="${CaseDtls.firstName}" name="firstName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" value="${CaseDtls.lastName}" name="lastName"></td>
			</tr>

			<tr>
				<td>Select Plan:</td>
				<td><form:select path="plns">
				<form:options items="${listplans}"/>
					<%-- <form:option value="SNAP">SNAP</form:option>
					<form:option value="CCAP">CCAP</form:option>
					<form:option value="KT">KT WORKS</form:option> --%>
				
				</form:select> </td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Next"></td>
			</tr>

		</table>
	</form:form>
</h1>
</body>
</html>