<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
<div>
<h3 align="center">Edit User page</h3>
</div>

<form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/admin/user/edit/${user.userID}.html">
<c>	
	<table class="form-group table">
		<tbody>
			<tr>
				<td align="right"><spring:message code="fieldLabel.userID" /></td>
				<td><form:input path="UserID" readonly="true" /></td>
				<td><form:errors path="UserID" cssStyle="color: red;" /></td>
				</tr>
			 
			<tr>
				<td align="right"><spring:message code="fieldLabel.password" /></td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.FirstName" /></td>
				<td><form:input path="FirstName" /></td>
				<td><form:errors path="FirstName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.LastName" /></td>
				<td><form:input path="LastName" /></td>
				<td><form:errors path="LastName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.Age" /></td>
				<td><form:input path="Age"/></td>
				<td><form:errors path="Age" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.Address" /></td>
				<td><form:input path="Address" /></td>
				<td><form:errors path="Address" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.Phone" /></td>
				<td><form:input path="Phone" /></td>
				<td><form:errors path="Phone" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td align="right"><spring:message code="fieldLabel.Gender" /></td>
				<td><form:radiobutton path="gender" value="Male"/>Male 
                <form:radiobutton path="gender" value="Female"/>Female </td>
				<td><form:errors path="gender" cssStyle="color: red;" /></td>
			</tr>
			
				<tr>
				<td align="right"><spring:message code="fieldLabel.Email" /></td>
				<td><form:input path="Email"/></td>
				<td><form:errors path="Email" cssStyle="color: red;" /></td>
			</tr>
				<tr>
				<td align="right"><spring:message code="fieldLabel.MemberID" /></td>
				<td><form:input path="MemberID"/></td>
				<td><form:errors path="MemberID" cssStyle="color: red;" /></td>
			</tr>
					<tr>
				<td align="right"><spring:message code="fieldLabel.Status" /></td>
				<td><form:radiobutton path="status" value="Active"/>Active 
                <form:radiobutton path="status" value="InActive"/>InActive </td>
				<td><form:errors path="status" cssStyle="color: red;" /></td>
			</tr>
					<tr>
				<td align="right"><spring:message code="fieldLabel.Role" /></td>
				<td><form:radiobutton path="role" value="User"/>User 
                <form:radiobutton path="role" value="Admin"/>Admin </td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
		
			<tr>
				<td align="right"><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr> 
		</tbody>
	</table>
	</c>
</form:form>

