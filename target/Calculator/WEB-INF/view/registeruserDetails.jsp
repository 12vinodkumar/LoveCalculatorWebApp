<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page isELIgnored="false" %>

<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: 30px;
}
</style>

<title>Register User</title>
</head>
<body>

<h1>Love Calculator</h1>

<dev align="center">
<form:form action="registeredUser" method="get" modelAttribute="userRegInfo" >

	<p>
	<label path="personName" > Name :</label> 
	<form:input path="personName"/>
	<form:errors path="personName" cssClass="error"></form:errors>
	</p>
	<br>
	<label> UserName : </label>
	<form:input path="userRegName"/>
	<form:errors path="userRegName" cssClass="error"></form:errors>
	<br>
	<label> Password :  </label>
	<form:password path="password"/>
	<br>
	<label> Country :  </label>
	<form:select path="country">
		<form:option value="India"></form:option>
		<form:option value="SriLanka"></form:option>
		<form:option value="Australia"></form:option>
		<form:option value="US"></form:option>
	</form:select>
	<br>
	<label> Hobbies :</label>
	Cricket :
	<form:checkbox path="hobbies" value="Cricket"/>
	Watching Movie : <form:checkbox path="hobbies" value="Movie"/>
	Reading<form:checkbox path="hobbies" value="Read"/>
	<br>
	Programming : <form:checkbox path="hobbies" value="Programming"/>
	Travel : <form:checkbox path="hobbies" value="Travel"/>
	<br>
	<label>Gender : </label> Male :
	<form:radiobutton path="gender" value="male"/> Female :
	<form:radiobutton path="gender" value="female"/>
	<br>
	<p>
	<label> Age :</label>
	<form:input path="age" id="age1"/>
	<form:errors path="age" cssClass="error"></form:errors>
	</p>
	<br>
	<h1 align="center"> Communication Details </h1>
	<label> PhoneNumber :</label>
	<form:input path="phoneNumber" id="phone1"/>
	<form:errors path="phoneNumber" cssClass="error"></form:errors>
	<br>
	<label> Email ID :</label>
	<form:input path="email" id="email1"/>
	<form:errors path="email" cssClass="error"></form:errors>
	<br>
	<input type="submit" value="register">

</form:form>
</dev>
</body>
</html>