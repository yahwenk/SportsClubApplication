<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Booking Update</title>

<link rel="STYLESHEET" type="text/css"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	
	<script>
		$(document).ready(function() {
			$("#datepicker1").datepicker({
				dateFormat : "dd-mm-yy",
				autoclose : true,
				minDate : '+1d'
			});
		});
		
	

	</script>

	<h3>Booking</h3>
	<form:form method="POST" modelAttribute="booking"
		action="${pageContext.request.contextPath}/booking/admin/edit/${booking.transactionID}">

		<center>
			<table cellpadding=4 cellspacing=2 border=0 class="form-group table">
				<form:hidden path="userID" />
				<tr>
					<td><s:message code="label.transactionno" /></td>
					<td><form:hidden path="transactionID" />${booking.transactionID } 
					<form:errors path="transactionID" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td><s:message code="label.facilityname" />*</td>

					<td><form:select path="facilityID">

							<c:forEach items="${facility}" var="fac">

								<form:option value="${fac.facilityID}">

									${fac.facilityName }

								</form:option>

							</c:forEach>

						</form:select></td>
						<form:errors path="facilityID" cssStyle="color: red;" /></td>
				</tr>


				<tr>

					<td><s:message code="label.date" /> *</td>
					<td><form:input size="16" path="bookingDate" id="datepicker1" />
					<form:errors path="bookingDate" cssStyle="color: red;" /></td>
				</tr>


					<tr>
					<td><s:message code="label.timeslot" /> *</td>

					<td><form:select path="bookingTime">
							<form:option value="9:00 to 10:00"></form:option>
							<form:option value="10:00 to 11:00"></form:option>
							<form:option value="11:00 to 12:00"></form:option>
							<form:option value="12:00 to 1:00"></form:option>
							<form:option value="1:00 to 2:00"></form:option>
							<form:option value="2:00 to 3:00"></form:option>
							<form:option value="3:00 to 4:00"></form:option>
							<form:option value="5:00 to 6:00"></form:option>
							<form:option value="6:00 to 7:00"></form:option>
							<form:option value="7:00 to 8:00"></form:option>
							<form:option value="8:00 to 9:00"></form:option>
						</form:select></td>
						<form:errors path="bookingTime" cssStyle="color: red;" /></td>

				</tr>
				
				<tr>
					<td><s:message code="label.status" /></td>
					<td>${booking.status }
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>


			</table>
		</center>

	</form:form>
	</body>
</html>