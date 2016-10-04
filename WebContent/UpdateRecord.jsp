<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "UpdateRecordServlet"  method ="post">

<% model.Gdgrade u = (model.Gdgrade) session.getAttribute("record");%>


		Record ID: <br>
		<input type="text" name="id" id="id" value="<%=u.getId()%>"/>
		<br>
		Student UserID: <br>
		<input type="text" name="userid" id="userid" value="%=u.getUserid()%>"/>
		<br>
		<br>
		Assignment: <br>
		<input type="text" name="assignment" id="assignment" value="<%=u.getAssignment()%>" />
		<br>
		<br>
		Assignment Type: <br>
		<input type="text" name="assignmenttype" id="assignmenttype" value="<%=u.getAssignmenttype()%>"   />
		<br>
		<br>
		Grade: <br>
		<input type="text" name=grade id="grade" value="<%=u.getGrade()%>"/>
		<br>
		<br>
		Subject: <br>
		<input type="text" name=subject id="subject" value="<%=u.getSubject()%>"/>
		<br>
		<br>
		<input type="submit" value="Submit" id="submit"  />	
</form>
</body>
</html>