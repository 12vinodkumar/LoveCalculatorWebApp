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

	<h1>Hi ${userInfo.userName} </h1>
<label>Successfully sent to the email ${emailValueObj.emailValue} </label>
</body>
</html>