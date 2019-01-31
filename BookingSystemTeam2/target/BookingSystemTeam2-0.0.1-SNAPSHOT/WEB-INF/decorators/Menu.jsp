<%-- 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url var="url_logout" value="/logout" />

<div id=menu>
	<c:if test="${sessionScope.USERSESSION.getUser().getUserID()==null}">
	User is not yet logged in: Guest Menu
	<spring:url var="url_register" value="/register" />
		<spring:url var="url_login" value="/index" />
		<a href="url_register"> <input type=button value="Register">
		</a>
		<a href="url_login"> <input type=button value="Login">
		</a>
	</c:if>

	<c:if
		test="${sessionScope.USERSESSION.getUser().getUserID()!=null && sessionScope.USERSESSION.getUser().getRole() == 'Admin'}">
	Admin is logged in : Admin Menu
	<spring:url var="url_mgF" value="/admin/Facility/list" />
		<spring:url var="url_mgU" value="/admin/user/list" />
		<spring:url var="url_mgB" value="/booking/booking" />

		<a href="url_mgU"> <input type=button value="Manage User">
		</a>
		<a href="url_mgF"> <input type=button value="Manage
		Facility">
		</a>
		<a href="url_mgB"> <input type=button value="Manage
		Booking">
		</a>
		<a href="url_logout"> <input type=button value="Logout">
		</a>
	</c:if>

	<c:if
		test="${sessionScope.USERSESSION.getUser().getUserID()!=null && sessionScope.USERSESSION.getUser().getRole() == 'User'}">
	User is logged in : User Menu
	<spring:url var="url_booking_booking" value="/booking/booking" />
		<spring:url var="url_booking_history" value="/booking/history" />
		<a href="url_booking_booking"> <input type=button
			value="Booking Facility">
		</a>
		<a href="url_booking_history"> <input type=button
			value="Booking History">
		</a>
		<a href="url_logout"> <input type=button value="Logout">
		</a>
	</c:if>
</div> --%>




<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url var="url_logout" value="/logout" />
<html lang="en-US">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Menu1.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${sessionScope.USERSESSION.getUser().getUserID()==null}">
				<nav class="nav" >

					<!-- <div>User is not yet logged in: Guest Menu</div> -->
					<spring:url var="url_register" value="/register" />
					<a href="${url_register}">Register</a>

					<spring:url var="url_login" value="/index" />
					<a href="${url_login}">Login</a>
				</nav>
			</c:if>

			<c:if
				test="${sessionScope.USERSESSION.getUser().getUserID()!=null && sessionScope.USERSESSION.getUser().getRole() == 'Admin'}">
				<nav class="nav">

					<!-- <div>Admin is logged in : Admin Menu</div> -->
					<div>
					<spring:url var="url_mgF" value="/admin/Facility/list" />
					<a href="${url_mgF}" class="btn btn-warning">Manage Facility</a>
					<spring:url var="url_mgU" value="/admin/user/list" />
					<a href="${url_mgU}" class="btn btn-warning">Manage User</a>
					<spring:url var="url_mgB" value="/booking/admin" />
					<a href="${url_mgB}" class="btn btn-warning">Manage Booking</a> 
					<a href="${url_logout}" class="btn btn-warning">Logout</a>
					</div>
				</nav>
			</c:if>


			<c:if
				test="${sessionScope.USERSESSION.getUser().getUserID()!=null && sessionScope.USERSESSION.getUser().getRole() == 'User'}">
				<nav class="nav">

					<!-- <div>User is logged in : User Menu</div> -->
					<div>
					<spring:url var="url_booking_booking" value="/booking/booking" />
					<a href="${url_booking_booking}" class="btn btn-warning">Booking Facility</a>
					<spring:url var="url_booking_history" value="/booking/history" />
					<a href="${url_booking_history}" class="btn btn-warning">Booking History</a> 
					<a href="${url_logout}" class="btn btn-warning">Logout</a>
					</div>
				</nav>
			</c:if>
		</div>
	</div>
	<div style="text-align: center; clear: both; margin-top: 50px">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
	</div>
</body>
</html>