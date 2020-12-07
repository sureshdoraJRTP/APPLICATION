<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
body {
   /* font-family: Arial, Helvetica, sans-serif;  */
  /* background-color: black; */
  background-image: url("images/h1.jpg") ;
  background-size: cover;
  height: 100%;
  
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: #0b26d6;
}

/* Full-width input fields [type=text], input[type=password]  */
input[type=text], input[type=password], input[type=date],input[type=number]{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
select {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
.manubtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.9;
  align-content: right;
}
/* Set a style for the submit button */
button {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  
  padding: 10px;
  text-align: center;
  font-size: 35px;
  color: black;
}

/* Create two columns/boxes that floats next to each other */


article {
  float: left;
  padding: 30px;
  width: 100%;
 
  height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}

</style>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery
.min.js"></script>
<script>
$(document).ready(function() {
	$("#userEmail").blur(function() {
		$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "uniqueMail?email="+$("#userEmail").val(),
				success : function(data) {
					console.log(data);
					if(data=="DUPLICATE"){
						$("#errMsg").text("Duplicate Email");
						$("#submitBtn").prop("disabled", true);
						}else{
						$("#submitBtn").prop("disabled", false);
						}
						}
						});
			
						});
});
</script>
</head>
<body >


<header>
  <h3 ><u>IES | Integreated Eligibility System</u></h3>
  <button class="manubtn"><a href="/appRegForm">Application Registration</a></button>&nbsp;&nbsp;
  <button class="manubtn"><a href="/ARviewAcc">Application Registration View</a></button>&nbsp;&nbsp;
   <button class="manubtn">Data Collection</button>&nbsp;&nbsp;
    <button class="manubtn">Eligibility Determination</button>&nbsp;&nbsp;
    <div class="dropdown">
  <button class="dropbtn">Admin</button>
  <div class="dropdown-content">
    <a href="/regForm">Account Creation</a>
    <a href="/viewAcc">View Account</a>
    <a href="#">Plan Creation</a>
     <a href="#">Plan Views</a>
  </div>
</div>
  
  </header>  <hr>
  
    <article>
    <b><font color="blue">${success}</font></b>
    <b><font color="red">${errorMsg}</font></b>
<form:form action="/registration1" method="POST" modelAttribute="emp" style="max-width:500px;margin:auto">
  <div class="container">
    <font color="#4CAF50"><h1 align="center" ><u> Account Registration</u> </h1></font>
<form:hidden path="empId"/>
   <label><b>First Name:</b></label>
   <form:input path="firstName" />
    
    <label><b>Last Name:</b></label>
    <form:input path="lastName" />
    

    <label><b>Email:</b></label>
    <form:input path="email" id="userEmail"/>
    <font color="red"><span id="errMsg" ></span></font></br>
    

    <label><b>Password:</b></label>
    <form:password path="password" />
    
    
    <label><b>Date Of Birth:</b></label>
    <form:input path="dob" type="date" />
    
	<label ><b>Gender:</b></label><br>
	<form:radiobutton path="gender" value="male"/>Male
	<form:radiobutton path="gender" value="female"/>Fe-Male
	<form:radiobutton path="gender" value="other"/>other
	   <br><br>
    <label ><b>SSN NO:</b></label>
    <form:input path="ssn"/>
   
    <label><b>Phone Number:</b></label>
    <form:input path="phoneNumber"/>
	  
	  <label ><b>Role:</b></label>
	  <form:select path="role">
	  <form:option value="none"> -Select-</form:option>
	  	  <form:option value="caseworker"> Case Worker</form:option>
	  	  <form:option value="admin"> Admin</form:option>
	  
	  
	  </form:select>

    <button type="submit"   id="submitBtn" >Register</button>
  </div>
  
  
</form:form></article>
<!-- <footer><h2>IES | Integreated Eligibility System</h2>&copy;</footer> -->
</body>
</html>
