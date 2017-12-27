<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Contact</title>
</head>
<body>
	<h2 style="color: red;" align="center">Add New Contact</h2><br>

	<form action="EmployeeBeanInit.jsp" method="post" style="color: green;">
		<h3 align="center">
			Enter Employee ID : 	<input type="text" name="id" ><br><br>
			Enter Employee Name : 	<input type="text" name="name" ><br><br>
			Enter Contact number : 	<input type="text" name="contact"><br><br>
			Enter Joining Date :  	<input type="date" name="tempDate" ><br><br>
			Enter Designation 		<select name="designation"> <option>CEO<option>HR<option>JE<option>SOFTWARE_ENGINEER<option>ASSISTANT_SYSTEM_ENGINEER</select><br><br>
									<input type="submit" value="Add Contact">
					
		</h3>
	</form>
	<a style="color: red">${errorMsg}</a>
</body>
</html>