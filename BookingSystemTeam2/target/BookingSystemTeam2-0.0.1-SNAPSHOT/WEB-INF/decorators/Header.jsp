<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="STYLESHEET" type="text/css" href="css/style.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div>
	<h1 id="HeadTitle">Club Application for Booking</h1>
	<h2 class="name_and_role">
		<c:if test="${not empty sessionScope.USERSESSION}">
			<c:out value="UserID: " />
			<c:out value="${sessionScope.USERSESSION.user.getUserID()}" /> ;
			<c:out value="User: " />
			<c:out value="${sessionScope.USERSESSION.user.getFirstName()}" /> ;
            <spring:message code="caption.role" /> :
            <c:out value="${sessionScope.USERSESSION.user.getRole()}" /> ;
		</c:if>
		<hr>
	</h2>
</div>


<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="STYLESHEET" type="text/css" href="css/style.css" />
<div>
	<h1 align="right">
		<spring:message code="title.application" />
	</h1>
	<h2>
		<c:if test="${not empty sessionScope.USERSESSION}">
			<spring:message code="caption.user" /> :
<c:out value="${sessionScope.USERSESSION.user.name}" /> ;
<spring:message code="caption.role" /> :
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
 ${role.roleId} ;
</c:forEach>

		</c:if>
	</h2>
</div>
 --%>