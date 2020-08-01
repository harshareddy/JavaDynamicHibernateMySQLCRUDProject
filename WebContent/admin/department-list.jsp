<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List </title> 
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <div class ="container">
 <br/>
 <br/>
 <a href="<%=request.getContextPath()%>/DepartmentManagement?action=new" class="btn btn-outline-success">Add New Department</a>
 <table class="table table-striped">     
	  <thead class="thead-dark">
		   <tr>
		       <th scope="col">Id</th>
			   <th scope="col">DepartmentName</th>
			   <th scope="col">DepartmentLocation</th>
			   <th scope="col">CreateUpdateDate</th>
			   <th scope="col">Action</th>
		   </tr>
	  </thead>
	  <tbody>
		   <c:forEach var="department" items="${departmentList}">
			     <tr>			        
			        <td><c:out value="${department.id}"/></td>
				    <td><c:out value="${department.name}"/></td>
				    <td><c:out value="${department.location}"/></td>				    
				    <td><c:out value="${department.creationdate}"/></td>
				    <td>
				      <a href="<%=request.getContextPath()%>/DepartmentManagement?action=edit&id=<c:out value="${department.id}"/>" class="btn btn-outline-primary">Edit</a>
				      <a href="<%=request.getContextPath()%>/DepartmentManagement?action=delete&id=<c:out value="${department.id}"/>" class="btn btn-outline-danger">Delete</a>
				    
				    </td>
			     </tr>		     
		  </c:forEach>
	  </tbody>
 </table>
</div>
</body>
</html>