<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page isELIgnored="false" %>
<title>Insert title here</title>
</head>
<body>

<br>

<h1>Hi ${userInfo.userName} </h1>

<form:form action="process-email" method="get" modelAttribute="emailDto" >
	<label> Enter Your Email : </label>
	<p>
	<form:input path="emailValue" id="email"/>
	</p>
	<input type="submit" value="send">
	
</form:form>

</body>
</html>