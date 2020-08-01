<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>

		<div class="container">
		    <form action="<%=request.getContextPath() %>/EmployeeManagement">
                <c:if test="${employee == null}">
	                <h2>New Employee</h2>        
	                <input type="hidden" name="action" value="create">
	            </c:if>
             <c:if test="${employee!=null}">
		            <h2>Edit Department</h2>        
		          <input type="hidden" name="action" value="update">
		          <input type="hidden" name="id"  value='<c:out value="${employee.id}"></c:out>'>   
			 </c:if>          
          <div class="form-group">
		    <label for="name">Employee Name</label>
		    <input type="text" class="form-control" name ="name" value='<c:out value="${employee.name}"></c:out>'>		   
		  </div>
		  <div class="form-group">
		    <label for="salary">Salary</label>
		    <input type="number" class="form-control" name="salary" value='<c:out value="${employee.salary}"></c:out>'>
		  </div>
		  <div class="form-group">
		    <label for="startdate">Start Date</label>
		    <input type="date" class="form-control" name="startdate" value='<c:out value="${employee.startDate}"></c:out>'>
		  </div>
		   <div class="form-group">
    		  <select name="department" class="form-control">
			    <c:forEach items="${departmentList}" var="department">
			        <option value="${department.id}" ${department.id == employee.department.id ? 'selected="selected"' : ''}>${department.name}</option>
			    </c:forEach>
            </select>
            </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
   </form>
		
		</div>




</body>
</html>