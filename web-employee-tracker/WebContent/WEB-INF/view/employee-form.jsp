<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Employee</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-employee-style.css"> 


</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Registration System</h2>
			
		</div>
		
		<div id="container">
			<h3>Save Employee</h3>
			
			<form:form action="saveEmployee" modelAttribute="employee" mehtod="POST">
			
			<form:hidden path="id"/>
			
				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"/></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					
					</tbody>
				
				</table>
			
			
			</form:form>
			
			<div style="clear;both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/employee/list"> Main Page </a>
			</p>
		
		</div>
	
	
	</div>
</body>

</html>