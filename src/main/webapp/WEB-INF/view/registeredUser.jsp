<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Registration Success !!!!</h1>
<br>
<label> Name : ${userRegInfo.personName}</label>
<br>
<label> userName : ${userRegInfo.userRegName}</label>
<br>
<label> password : ${userRegInfo.password}</label>
<br>
<label> country : ${userRegInfo.country}</label>
<br>
<label> hobbies : ${userRegInfo.hobbies}</label>
<br>
<label> gender : ${userRegInfo.gender}</label>
<br>
<label> Age : ${userRegInfo.age}</label>

</body>
</html>