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
<form:form action="Savechild" method="post" modelAttribute="dc">
		<table>
			<tr>
				<td>Case Id</td>
				<td><input type="text" value="${planDtls.caseId}" name="caseId"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${planDtls.firstName}" name="firstName"></td>
			
				<td><input type="text" value="${planDtls.lastName}" name="lastName"></td>
			</tr>
<tr>
				<td>Child Name:</td>
				<td><input type="text"  name="childName"></td>
			
			</tr>
			<tr>
				<td>Child Gender:</td>
				<td>
		<form:radiobutton path="childGender" value="Male"/>Male
		<form:radiobutton path="childGender" value="Female"/>Fe-Male
		
		</td>
			</tr>
<tr>
		<td>DOB</td>		<td><input type="date" name="cdob"></td>

</tr>
<tr>
		<td>SSN</td>		<td><input type="number" name="ssn"></td>

</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Next"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>