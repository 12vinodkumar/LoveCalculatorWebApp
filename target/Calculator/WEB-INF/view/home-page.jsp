<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: 30px;
}
</style>
<!-- 
<script type="text/javascript">

function validateUserName() {
	var userName = document.getElementById('yn').value;
	if (userName.length < 2) {
		alert("username atleast contains two letter ");
		return false;	
	}
	else {
		return true;
	}
		
}
 
</script>
-->
 

<meta charset="UTF-8">
<title>Love Calculator</title>
</head>
<body>

	<h1 align="center">Love Calculator</h1>
<hr/>
<form:form action="process-homepage" method="get" modelAttribute="userInfo">
<dev align="center">
	<p>
		<label for="yn">Your Name :</label>
		<form:input  id="yn" path="userName" />
		<form:errors path="userName" cssClass="error"></form:errors>
	</p>
	<p>
		<label for="cn">Crush Name :</label>
		<form:input  id="cn" path="crushName" />
		<form:errors path="crushName" cssClass="error"></form:errors>
	</p>
	<p>
		<form:checkbox path="termsAndConditionAccepted" id="tc" />
		<label>Agreeing to this is just for fun</label>
		<form:errors path="termsAndConditionAccepted" cssClass="error"></form:errors>
	</p>
	
	<p>
		<input type="submit" value="calculate">
		</p>
</dev>
</form:form>
</body>
</html>