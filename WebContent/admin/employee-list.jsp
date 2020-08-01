<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<br/> <br/>

 <div class="container" >
 <br/>
 <br/>
     <a href="<%=request.getContextPath()%>/EmployeeManagement?action=new" class="btn btn-outline-success">Add Employee</a>
     <table class="table table-striped">
        <thead class="thead-dark">
         <tr>
           <th scope="col">Id</th>
           <th scope="col">Name</th>
           <th scope="col">Salary</th>
           <th scope="col">StartDate</th>
           <th scope="col">Department</th>
           <th scope="col">Action</th>
         </tr>
       </thead>
       <tbody>
       
          <c:forEach  var="employee" items="${employeeList}">
	          <tr>
		           <td><c:out value="${employee.id}"></c:out> </td>
		           <td><c:out value="${employee.name}"></c:out> </td>
		           <td><c:out value="${employee.salary}"></c:out> </td>
		           <td><c:out value="${employee.startDate}"></c:out> </td>
		           <td><c:out value="${employee.department.name}"></c:out> </td>         
		           <td> 
		                <a href="<%=request.getContextPath()%>/EmployeeManagement?action=edit&id=<c:out value="${employee.id}"/>" class ="btn btn-outline-primary"> Edit</a>
					    <a href="<%=request.getContextPath() %>/EmployeeManagement?action=delete&id=<c:out value="${employee.id}"/>" class ="btn btn-outline-danger"> Delete</a>
				   </td>
			   </tr>
          </c:forEach>
       
       

       
       </tbody>
     </table>
 
 
 </div>


</body>
</html>