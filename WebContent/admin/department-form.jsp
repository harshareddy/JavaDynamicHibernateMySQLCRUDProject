<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>
<div class ="container">
   <form action="<%=request.getContextPath() %>/DepartmentManagement">
   <c:if test="${department == null}">
         <h2>New Department</h2>        
          <input type="hidden" name="action" value="create">
   </c:if>
   <c:if test="${department!=null}">
            <h2>Edit Department</h2>        
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="id"  value='<c:out value="${department.id}"></c:out>'>   
   </c:if>          
          <div class="form-group">
		    <label for="name">Department Name</label>
		    <input type="text" class="form-control" name ="name" value='<c:out value="${department.name}"></c:out>'>		   
		  </div>
		  <div class="form-group">
		    <label for="country">Department Country</label>
		    <input type="text" class="form-control" name="country" value='<c:out value="${department.location}"></c:out>'>
		  </div>
		  <div class="form-group">
		    <label for="creationdate">Creation Date</label>
		    <input type="date" class="form-control" name="creationdate" value='<c:out value="${department.creationdate}"></c:out>'>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
   </form>
</div>   

</body>
</html>