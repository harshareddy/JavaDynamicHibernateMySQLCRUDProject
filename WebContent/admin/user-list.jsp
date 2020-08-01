<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Portal</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	<div class="container">
        <br/>
        <br/>
        <a href="<%=request.getContextPath()%>/UserManagement?action=new" class="btn btn-outline-success">Add New User</a>
		<table class="table table-striped" >
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.country}" /></td>
						<td>
						  <a href="<%=request.getContextPath()%>/UserManagement?action=edit&id=<c:out value="${user.id}"/>" class ="btn btn-outline-primary"> Edit</a>
						  <a href="<%=request.getContextPath() %>/UserManagement?action=delete&id=<c:out value="${user.id}"/>" class ="btn btn-outline-danger"> Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>