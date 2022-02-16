<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page isELIgnored="false" %>
<title>Process home Page</title>
</head>
<body>

<h1 align="center"> Processing Home Page !!!!!!!</h1>

<p>UserName : ${userInfo.userName} </p>
<p>CrushName : ${userInfo.crushName} </p>
<p> Matching Result : ${appResult} </p>


<a href = "<c:url value = "/sendEmail"/>">send Result to your Email</a>

<!-- <a href="/Calculator/process-email">Success Email</a>  -->
</body>
</html>