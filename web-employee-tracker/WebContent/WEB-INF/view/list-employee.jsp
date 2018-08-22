<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Employee</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2> Employee Registration System</h2>	
		
		</div>
	
	</div>
	
	<div id= "container">
		<div id="content">
			
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
		
				</tr>
				<c:forEach var="tempEmployee" items="${employees}">
					
					 <c:url var="updatelink" value="/employee/showFormForUpdate">
					 	<c:param name="employeeId" value="${tempEmployee.id}"/>
					 </c:url>
					 
					 <c:url var="deletelink" value="/employee/delete">
					 	<c:param name="employeeId" value="${tempEmployee.id}"/>
					 </c:url>
					
					<tr>
						<td>${tempEmployee.firstName}</td>
						<td>${tempEmployee.lastName}</td>
						<td>${tempEmployee.email}</td>
						<td>
							<a href="${updatelink}">Update</a>
						 	|
							<a href="${deletelink}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<input type="button" value="Register New Employee"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button"
			/>
	
		</div>
	</div>
</body>

</html>