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
<form:form action="Saveincome" method="post" modelAttribute="dc">
		<table>
			<tr>
				<td>Case Id</td>
				<td><input type="text" value="${planDtls.caseId}" name="caseId"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${planDtls.firstName}" name="name"></td>
			
				<td><input type="text" value="${planDtls.lastName}" name="name"></td>
			</tr>

			<tr>
				<td>Is Working Employee:</td>
				<td>
		<form:radiobutton path="isEmployee" value="Y"/>Yes
		<form:radiobutton path="isEmployee" value="N"/>No
		
		</td>
			</tr>
<tr>
		<td>Income</td>		<td><input type="number" name="income"></td>

</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Next"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>