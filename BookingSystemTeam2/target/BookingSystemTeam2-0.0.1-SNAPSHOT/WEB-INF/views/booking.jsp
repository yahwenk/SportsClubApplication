<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booking</title>

<link rel="STYLESHEET" type="text/css"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.7),
		rgba(255, 255, 255, 0.7)), url("../image/bg1.jpg");
	background-size: cover;
	background-position: top right;;
}
</style>

<link rel="STYLESHEET" type="text/css"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</head>

<body>

<script>
$(document).ready(function() {
	$("#datepicker").datepicker({
		dateFormat : "dd-mm-yy",
		minDate : '+1d'
	});
});

$(function() {

	$("#datepicker").datepicker();
	$("#datepicker").on(
			"change",
			function() {
				var selected = $(this).val();

				var ddl = document.getElementById("selectFacility");
				var selectedValue = ddl.options[ddl.selectedIndex].value;
				if (selectedValue != "0") {
					var selfac = ddl.options[ddl.selectedIndex].value;
				}

				$.ajax({
					type : 'GET',

					url : window.location + "/" + selfac + "/" + selected,

					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						
						var slctSubcat = $('#selectTimeSlot'), option = "";
						slctSubcat.empty();

						$.each(data, function(index, value) {
							$('#selectTimeSlot').append(
									$('<option>').text(value).val(index));
						});
					}
				});
			});
});


$(function() {
$("#selectTimeSlot").change(function() {
		$('#myhidden').val($('option:selected', this).text());

	});
});



</script>
	
	
	

	<h3 id="bookingtitle">Booking</h3>
	<form:form method="POST" modelAttribute="booking"
		action="${pageContext.request.contextPath}/booking/booking">
		<center>
			<table cellpadding=4 cellspacing=2 border=0 align="left"
				class="form-group table">


				<tr>
					<td align="right"><s:message code="label.facilityname" />*</td>
					<td><form:select id="selectFacility" path="fac.facilityID">
							<form:option value="0" label="---Select---" />
							<c:forEach items="${facility}" var="fac">

								<form:option value="${fac.facilityID}">

									${fac.facilityName }

								</form:option>

							</c:forEach>

						</form:select></td>
					<form:errors path="fac.facilityID" cssStyle="color: red;" />
				</tr>
				<tr>

					<td align="right"><s:message code="label.date" /> *</td>
					<td><form:input size="16" path="bookingDate" id="datepicker" />
						<form:errors path="bookingDate" cssStyle="color: red;" /></td>

				</tr>


				<tr>
					<td align="right"><s:message code="label.timeslot" /> *</td>

					<td><select id="selectTimeSlot">
							<option value="NONE" label="---Select---" />

					</select> <form:input type="hidden" id="myhidden" name="seltime"
							path="bookingTime" /> <form:errors path="bookingTime"
							cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td align="right"><s:message code="label.status" /></td>
					<td>PENDING</td>

				</tr>

				<td align="right"><input type="submit" value="Submit"
					class="button"></td>
				<td><input type="reset" value="Reset"></td>


			</table>
		</center>

	</form:form>

</body>
</html>