<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="nus.iss.team2.model.Facility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="nus.iss.team2.model.Booking"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Booking History by Admin</title>
</head>
<body>

	<h3>View Booking History by Admin</h3>
	<c:if test="${fn:length(bhistory) gt 0}">

	<table style="cellspacing: 2; cellpadding: 2; border: 1;" class="table table-hover">
		<tr class="listHeading">
			<th><spring:message code="label.transactionno" /></th>
			<th><spring:message code="label.facilityname" /></th>
			<th><spring:message code="label.date" /></th>
			<th><spring:message code="label.timeslot" /></th>
			<th><spring:message code="label.status" /></th>

			<th><spring:message code="label.edit" /></th>
			<th><spring:message code="label.delete" /></th>
		</tr>
		<c:forEach var="transaction" items="${bhistory}">
				<tr class="listRecord">
					<td>${transaction.bookingID}</td>
					
					<td>${transaction.fac.facilityName}</td>
					<td>${transaction.bookingDate}</td>
					<td>${transaction.bookingTime}</td>
					<td>${transaction.status}</td>

			<td><a
				href="${pageContext.request.contextPath}/booking/admin/edit/${transaction.bookingID}">

					<spring:message code="label.edit" />
			</a></td>
			<td><a
				href="${pageContext.request.contextPath}/booking/admin/delete/${transaction.bookingID}">

					<spring:message code="label.delete" />
			</a></td>
		
			



		</tr>
		</c:forEach>
	</table>
	
	</c:if>

</body>
</html>