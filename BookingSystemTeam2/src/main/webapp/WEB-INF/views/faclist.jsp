
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<h1 align="center">
	<spring:message code="Facility List" />
</h1>
<a href="${pageContext.request.contextPath}/admin/Facility/create"
 style="position: relative; margin-left: 70%;"> Add Facility</a> <br/>

<table class="table table-hover" style="width: 55%; margin-top: 20px;">
	<tr>
		<th>Facility ID</th>
		<th>Facility Name</th>
		<th>Status</th>
		<th align="center">Edit</th>
		<th align="center">Delete</th>
	</tr>
	<tbody>

		<c:forEach var="faclitylist" items="${facList}">
			<tr>
				<td>${faclitylist.facilityID}</td>
				<td>${faclitylist.facilityName}</td>
				<td>${faclitylist.status}</td>

				<!-- <style>
.button {
    background-color: #B3B6B7  ;
    border: thin;
    color: black;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;

    font-size: 15px;
    margin: 2px 1px;
    cursor: pointer;
    
    background-color: white;
    color: black;
    border: 2px solid #555555;

}

</style> -->
				<td><a
					href="${pageContext.request.contextPath}/admin/Facility/edit/${faclitylist.facilityID}.html">
						Edit</a></td>

				<td><a
					href="${pageContext.request.contextPath}/admin/Facility/delete/${faclitylist.facilityID}.html">
						Delete</a></td>

			</tr>


		</c:forEach>
	</tbody>

</table>

</body>
</html>

