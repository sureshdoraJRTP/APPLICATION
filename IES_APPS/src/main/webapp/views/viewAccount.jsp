<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
     background-image: url("images/h1.jpg") ;
  background-size: cover;
  height: 100%;
					}
table {   
        border: 8px solid #f1f1f1;
        height: 155px;
        width:90%;
        background-color: lightblue;
        
         
   
       
         
    }   
    
          #d1left
            {
                
                width: 20%;
                height: 200px;
                float: left;
            }
            #d1right
            {
                /* background-color: skyblue; */
                width: 66%;
                height: 500px;
                float: left;
                border-color: black;
                border-style: solid;
               padding: 70px;
                
            }
           
            
   .d1{
        padding: 5px;   
         
   }
     
		 /* Add a blue text color to links */
a {
  color: dodgerblue;
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

header {
  
  padding: 10px;
  text-align: center;
  font-size: 35px;
  color: black;
}

</style>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery
.min.js"></script>
<!-- <script >
$(document).ready(function(){
$(".sel").change(function(){
var work=$(this).val();
if(work==admin){
	<a hr
}
	$.ajax({
		type : "GET",
		url : "viewAcc?role="+$(this).val(),
		success : function(data) {
			 $.each(data, function(empId, firstName,lastName,email,role) {
		        });
		}
	});
});
});  -->  
</script>
</head>
<body>
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
<h3>
<div class="d1">
	
</div>
<div><h1></h1></div>
<div id="d1left"></div>



	<div id="d1right">
	
	<center><h2><u>View Account</u></h2></center>
	<table  border="6px" bgcolor="black" >
 <label  ><b>Role:</b></label>
<select onchange="location = this.value;">  
<option value="none" selected disabled hidden> 
          -Select-
                <option value="workerviewAcc?role=caseworker">Case Worker</option>
                <option value="workerviewAcc?role=admin">Admin</option>
                
</select>


  
<b><font color="blue">${status}</font></b>
<tr bgcolor="white">

<th>S.No</th>
<th>FIRST NAME</th>
<th>LAST NAME</th>
<th>EMAIL</th>
<th>ROLE</th>
<th>ACTION</th>

</tr>
<c:forEach var="emp" items="${getEmployee}" >
<tr bgcolor="white">

<td>${emp.empId}</td>
<td>${emp.firstName}</td>
<td>${emp.lastName}</td>
<td>${emp.email}</td>
<td>${emp.role}</td>
<td><a href="editEmpAcc?empId=${emp.empId}"><img  src="/images/edit1.jpg"width="30" height="30"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="softDelete?empId=${emp.empId}">
<img  src="/images/deactive1.jpg"width="30" height="30">
</a>

</td>

</tr>
</c:forEach>
<tr></tr>
<tr></tr>
</table>

</div>
</h3>
</body>

</html>