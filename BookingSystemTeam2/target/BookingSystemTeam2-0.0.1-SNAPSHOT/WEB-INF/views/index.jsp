<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Club Application Booking (CAB)</title>
<link href="css/LoginReg.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container">
		<h1>Welcome to CAB</h1>

		<!-- Content -->
		<div class="login">
			<h3>User Login</h3>
			<br />
			<c:if test="${err!=null}">
				<p class="error">${err}</p>
			</c:if>
			<c:if test="${param.act eq 'lo'}">
				<p class="success">Logout Successfully! Thanks for using CAB!</p>
			</c:if>
			<c:if test="${param.act eq 'reg'}">
				<p class="success">User Register Successfully! Thanks for
					joining us!</p>
			</c:if>
			<spring:url var="url_login" value="login" />
			<form:form action="${url_login}" modelAttribute="loginCommand">

				<form:input class="user" type="text" path="userID"
					placeholder="User ID" />
				<%-- onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'User ID';}" --%>

				<form:password class="pass" path="password" placeholder="Password" />
				<input name="submit" type="submit" value="Login" />
				<br />
				<div align="right">
					<spring:url var="url_register" value="/register" />
					<a href="${url_register}">No Account?</a>
				</div>
			</form:form>
		</div>
		<!-- Menu -->
		<div align="center">
			<br /> <br />
			<jsp:include page="include/menu.jsp" />
		</div>
	</div>
		<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> Copyright &copy; ISS NUS SA46 Team 2 2018 </small>
	</div>
</body>
</html>