<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="css/LoginReg.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${err!=null}">
		<p class="error">Incorrect UserID or Password,${err}</p>
	</c:if>
	<c:if test="${param.act eq 'reg'}">
		<p class="success">User Register Successfully! Thanks for using
			CAB!</p>
	</c:if>
	<c:url value="/index" var="indexURL"></c:url>
	<a href="${indexURL}">Login</a>
	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> Copyright &copy; ISS NUS SA46 Team 2 2018 </small>
	</div>
</body>
</html>