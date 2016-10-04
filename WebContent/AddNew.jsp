<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

	function validate(form) 
	{
	    valid =true;
	   alert($('userid').val());
	    if ($('#userid').val().length==0)
		{
    alert("You may not submit an empty post.");
    valid = false;
}

	      return valid;
	}
</script>
<title>Insert title here</title>
</head>
<body>

	<h4>Adding grades</h4>
	
	<form action="AddNewServlet" method="post" onsubmit="return validate(this);" >
		Student UserID: <br>
		<input type="text" name="userid" id="userid" placeholder="Student user ID"  />
		<br>
		<br>
		Assignment: <br>
		<input type="text" name="assignment" id="assignment" placeholder="Assignment Name"  />
		<br>
		<br>
		Assignment Type: <br>
		<input type="text" name="assignmenttype" id="assignmenttype" placeholder="Midterm,Final,etc"  />
		<br>
		<br>
		Grade: <br>
		<input type="text" name=grade id="grade" placeholder="A-F"  />
		<br>
		<br>
		Subject: <br>
		<input type="text" name=subject id="subject" placeholder="Course Name"  />
		<br>
		<br>
		<input type="submit" value="Submit" id="submit" />	

	</form>
	

	
</body>
</html>