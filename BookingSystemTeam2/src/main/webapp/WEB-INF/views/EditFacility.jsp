<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<div>
	<h2 align="center">Edit Facility</h2>
</div>
<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/admin/Facility/edit/${facility.facilityID}.html">

	<table class="form-group table">
		<tbody>
			<tr>
				<td align="right"><spring:message code="fieldLabel.facilityID" /></td>
				<td><form:hidden path="facilityID"/>${facility.facilityID}</td>
			</tr>
			<tr>
				<td align="right"><spring:message
						code="fieldLabel.facilityName" /></td>
				<td><form:input path="FacilityName"  /></td>

			</tr>

			<tr>
				<td align="right"><spring:message code="fieldLabel.status" /></td>
				<td><form:input path="status"  /></td>

			</tr>
			<tr>
				<td align="right"><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

