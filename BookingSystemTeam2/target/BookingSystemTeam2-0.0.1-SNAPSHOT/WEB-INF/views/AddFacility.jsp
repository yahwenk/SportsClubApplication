<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<h2 align="center">Create New Facility</h2>

<form:form method="POST" modelAttribute="Facility"
	action="${pageContext.request.contextPath}/admin/Facility/create.html">
	
		<table class="form-group table">
			<tbody>
				<tr>
					<td align="right"><spring:message code="label.facID" /></td>
					<td><form:input path="FacilityID"  />
				</tr>
				<tr>
					<td align="right"><spring:message code="label.facName" /></td>
					<td><form:input path="FacilityName"  /></td>
				</tr>
				<tr>
					<td align="right"><spring:message code="label.facStatus" /></td>
					<td><form:input path="Status"  /></td>
				</tr>


				<tr>
					<td align="right"><input type="submit" value="Submit" class="button">
					</td>
					<td><input type="reset" value="Reset" class="button"></td>
				</tr>
			</tbody>
		</table>
	
</form:form>


</body>
</html>
