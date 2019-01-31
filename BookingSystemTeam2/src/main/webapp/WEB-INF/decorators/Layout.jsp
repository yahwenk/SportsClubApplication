<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@include file="Header.jsp"%>
<c:url value="/css/style.css" var="ss" />
<link rel="STYLESHEET" type="text/css" href="${ss}" />

<dec:head />
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td style="height: 20px; weight:auto;border: 1" valign="top">
				<div id="menu">

					<%@ include file="Menu.jsp"%>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div>
					<h3>
						<spring:message code="${bodyTitle}" />
					</h3>

					<dec:body />
				</div>
			</td>
		</tr>
	</table>

	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> Copyrights&copy; ISS NUS SA46 [2018] </small>
	</div>
</body>
</html>
