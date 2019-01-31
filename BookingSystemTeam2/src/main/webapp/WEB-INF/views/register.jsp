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
	<div class="container">
		<h1>User Registration Form</h1>

		<br />
		<!-- Content -->
		<div class="register">
			<c:if test="${err!=null}">
				<p class="error">${err}</p>
			</c:if>
			<spring:url var="url_register" value="/registerProcess" />
			<form:form method="post" action="${url_register}"
				modelAttribute="registerCommand">

				<table class="registerTable">
					<tr>
						<td class="tdLable">User ID:</td>
						<td><form:input type="text" path="userID"
								cssClass="inputStyle" /> <form:errors path="userID"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">First name:</td>
						<td><form:input type="text" path="firstName"
								cssClass="inputStyle" /> <form:errors path="firstName"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Last name:</td>
						<td><form:input type="text" path="lastName"
								cssClass="inputStyle" /> <form:errors path="lastName"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Age:</td>
						<td><form:input type="text" path="age"
								onkeyup="value=value.replace(/[a-zA-Z]+/,'').substring(0,3)"
								placeholder="15-120 years old" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '15-120 years old';}"
								cssClass="inputStyle" /> <form:errors path="age"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Address:</td>
						<td><form:textarea type="textarea" path="address"
								cssClass="inputStyle" /> <form:errors path="address"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Phone:</td>
						<td><form:input type="text" path="phone"
								onkeyup="value=value.replace(/[a-zA-Z]+/,'').substring(0,11)"
								placeholder="8-11 numbers" cssClass="inputStyle" /> <form:errors
								path="phone" cssStyle="color: red" /></td>
						<!-- /[^\d]/g -->
					</tr>
					<tr height="10px">
						<td colspan="2"></td>
					</tr>
					<tr>
						<td class="tdLable">Gender:</td>
						<td class="tdGender">Male: <form:radiobutton path="gender"
								value="M" /> Female:<form:radiobutton path="gender" value="F" />
							<br /> <form:errors path="gender" cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Password:</td>
						<td><form:input type="password" path="password" minlength="8"
								maxlength="11" cssClass="inputStyle" /> <br /> <form:errors
								path="password" cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">Email:</td>
						<td><form:input type="text" path="email"
								cssClass="inputStyle" /> <form:errors path="email"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td class="tdLable">MemberID:</td>
						<td><form:input type="text" path="memberID"
								cssClass="inputStyle" /> <form:errors path="memberID"
								cssStyle="color: red" /></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="Submit"
							name="register" />
					</tr>
					<tr>
						<td colspan=2><button type="reset" value="Reset" name="reset">Reset</button>
					</tr>
				</table>
			</form:form>
			<!-- Menu -->
			<div align="center">
				<br /> <br />
				<jsp:include page="include/menu.jsp" />
			</div>
		</div>
	</div>
	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> Copyright &copy; ISS NUS SA46 Team 2 2018 </small>
	</div>
</body>
</html>