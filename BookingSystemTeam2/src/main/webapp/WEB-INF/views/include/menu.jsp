<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${sessionScope.USERSESSION.getUser().getUserID()==null}">
	<%--User is not yet logged in: Guest Menu --%>
	<spring:url var="url_register" value="/register" />
	<spring:url var="url_login" value="/index" />
	<a href="${url_login}">Login</a> | <a href="${url_register}">Register</a>
</c:if>
