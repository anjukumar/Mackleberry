
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student | Home</title>
</head>
<body>
	<center>
		<%
			model.Gduser u = (model.Gduser) session.getAttribute("User");
		%>
		<h2>
			Welcome Student,
			<%=u.getUsername()%></h2>

		<form>
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th>UserId</th>
						<th>Assignment</th>
						<div></div>
						<th>Assignment Type</th>
						<th>Grade</th>
						<th>Subject</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="record" items="${records}">
						<tr>
							<td><c:out value="${record.userid}" /></td>
							<td><c:out value="${record.assignment}" /></td>
							<td><c:out value="${record.grade}" /></td>
							<td><c:out value="${record.subject}" /></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>

		</form>
	</center>
</body>
</html>