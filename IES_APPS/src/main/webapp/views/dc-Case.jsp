<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">Home</a>
  
  <div class="search-container">
    <form action="/findId">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
     <b><font color="blue">${SuccessMsg}</font></b>
    <b><font color="red">${ErrorMsg}</font></b>
    <b><font color="red">${errorMsg}</font></b>
  </div>
</div>
</br></br></br></br>

<h3>
<center>
<h2><u>CREATE CASE</u></h2>
<form:form action="plans" method="post" modelAttribute="dc">
  <table >
  
  	<tr>
  		<td>Application Id:</td>
  		<td><input type="text" value="${Search.citizenId}" name="citizenId" > </td>
  	</tr>
  	
  	<tr>
  		<td>Name :</td>
  		<td><input type="text" value="${Search.firstName}" name="firstName" ><input type="text" value="${Search.lastName}" name="lastName" ></td>
  	</tr>
  	<tr>
  		<td>Date Of Birth:</td>
  		<td><input type="text" value="${Search.dob}" name="dob" ></td>
  	</tr>
  	<tr>
  		<td>Gender:</td>
  		<td><input type="text" value="${Search.gender}" name="gender" ></td>
  	</tr>
  	<tr>
  		<td>SSN:</td>
  		<td><input type="text" value="${Search.ssn}" name="ssn" ></td>
  	</tr>
  	<tr>
  		<td>Phone Number:</td>
  		<td><input type="text" value="${Search.phoneNumber}" name="phoneNumber"></td>
  	</tr>
  	<tr>
  		<td>Email:</td>
  		<td><input type="text" value="${Search.email}" name="email" ></td>
  	</tr>
  	<tr>
  		<td></td>
  		<td><input type="submit" value="Create Case"></td>
  	</tr>
  	
  </table>
  </form:form>
</center>
</h3>
</body>
</html>
