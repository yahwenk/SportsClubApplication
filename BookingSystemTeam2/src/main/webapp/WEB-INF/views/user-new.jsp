<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<h3 align="center">New User page</h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
	
	<table class="form-group table">
		<tbody>
			<tr>
				<td align="right"><spring:message code="fieldLabel.userID" /></td>
				<td><form:input path="userID" /></td>
				<td><form:errors path="userID" cssStyle="color: red;" /></td>
			</tr>
		 	<tr>
				<td align="right"><spring:message code="fieldLabel.FirstName" /></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssStyle="color: red;" /></td>
			</tr>	
			<tr>
				<td align="right"><spring:message code="fieldLabel.LastName" /></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color: red;" /></td> 
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.Age" /></td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssStyle="color: red;" /></td>
			</tr>
				<tr>
				<td align="right"><spring:message code="fieldLabel.Address" /></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssStyle="color: red;" /></td>
			</tr>
				<tr>
				<td align="right"><spring:message code="fieldLabel.Phone" /></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssStyle="color: red;" /></td>
			</tr>
				<tr>
				<td align="right"><spring:message code="fieldLabel.Gender" /></td>
				<td><form:radiobutton path="gender" value="Male"/>Male 
                <form:radiobutton path="gender" value="Female"/>Female </td>
				<td><form:errors path="gender" cssStyle="color: red;" /></td>
			</tr>
				<tr>
				<td align="right"><spring:message code="fieldLabel.Email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
			</tr>
			
					<tr>
				<td align="right"><spring:message code="fieldLabel.MemberID" /></td>
				<td><form:input path="memberID" /></td>
				<td><form:errors path="memberID" cssStyle="color: red;" /></td>
			</tr>
			
					<tr>
				<td align="right"><spring:message code="fieldLabel.Status" /></td>
				<td><form:radiobutton path="status" value="Active"/>Active
                <form:radiobutton path="status" value="InActive"/>InActive</td>
				<td><form:errors path="status" cssStyle="color: red;" /></td>
			</tr>
			
					<tr>
				<td align="right"><spring:message code="fieldLabel.Role" /></td>
				<td><form:radiobutton path="role" value="User"/>User 
                <form:radiobutton path="role" value="Admin"/>Admin</td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			
					<tr>
				<td align="right"><spring:message code="fieldLabel.password" /></td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
  
			<tr>
				<td align="right"><input type="submit" value="Create" /></td>
				<td><input type="reset" value="Reset" class="button"></td>
				<td><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin/user/list';" value="User List" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
</form:form>

