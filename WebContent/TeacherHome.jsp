
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function submit() 

{
	valid = true;
	if($('#grade').val().length == 0)
	{
	alert("You have successfully added data.");
	valid = false;
	}
	return valid;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ITeacher | Home</title>
</head>
<body>
<center>
	<% model.Gduser u = (model.Gduser) session.getAttribute("User");%>
	<h2>Welcome Prof. <%= u.getUsername()%></h2>
	 <div class="container">

<form action="AddNewServlet" method="post">
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
    	<th>UserId</th>
    	<th>Assignment</th><div></div>
    	<th>Assignment Type</th>
    	<th>Grade</th>
    	<th>Subject</th>
    	</tr>
    </thead>
    <tbody>
    <c:forEach var="records" items="${records}">
        <tr><td> <c:out value="${records.userid}"/></td>
        	<td><c:out value="${records.assignment}"/></td>
     	   <td><c:out value="${records.grade}"/></td>
     	     <td><c:out value="${records.subject}"/></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
   		<input type="submit" value="Update" id="submit" />	
</form>
</div>
<form action="AddNew.jsp">
    <button type="submit">Add New</button>
</form>
	<br><br><br><br>
	   
</center>
</body>
</html>