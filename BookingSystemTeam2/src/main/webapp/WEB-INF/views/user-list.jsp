
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" /> 
<h1 align="center">
User List
</h1>
<a href="${pageContext.request.contextPath}/admin/user/create" style="position: relative; margin-left: 80%;">Add User</a>
<c:if test="${fn:length(userList) gt 0}">
<table class="table table-hover" style="margin-top: 20px;">
		<thead>
			<tr>
				<th><spring:message code="fieldLabel.userID" /></th>
				<th><spring:message code="fieldLabel.FirstName" /></th>
				<th><spring:message code="fieldLabel.LastName" /></th>
				<th><spring:message code="fieldLabel.Age" /></th>
				<th><spring:message code="fieldLabel.Address" /></th>
				<th><spring:message code="fieldLabel.Phone" /></th>
				<th><spring:message code="fieldLabel.Gender" /></th>
				<th><spring:message code="fieldLabel.Email" /></th>
				<th><spring:message code="fieldLabel.MemberID" /></th>
				<th><spring:message code="fieldLabel.Status" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td style="text-align:left">${user.userID}</td>
					<td style="text-align:center">${user.firstName}</td>
					<td style="text-align:center">${user.lastName}</td>
					<td style="text-align:left">${user.age}</td>
					<td style="text-align:center">${user.address}</td>
					<td style="text-align:left">${user.phone}</td>
					<td style="text-align:center">${user.gender}</td>
					<td style="text-align:center">${user.email}</td>
					<td style="text-align:center">${user.memberID}</td>
					<td style="text-align:center">${user.status}</td>
					<td align="left">
					<a href="${pageContext.request.contextPath}/admin/user/edit/${user.userID}.html">
					<spring:message code="caption.edit" /></a></td>
					<td><a href="${pageContext.request.contextPath}/admin/user/delete/${user.userID}.html">
					<spring:message code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>