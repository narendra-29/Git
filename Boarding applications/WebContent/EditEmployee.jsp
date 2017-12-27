<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Contact</title>
</head>
<body >
	<h2 style="color: red;" align="center">Add New Contact</h2><br>

	<form action="UpdateEmployeeBeanInit.jsp" method="get" style="color: blue;">
		Enter Employee ID  		: <input type="text" name="id"  value="${param.name}"><br><br>
		Enter Employee Name 	: <input type="text" name="name" value="${param.email}"><br><br>
		Enter Contact number 	: <input type="text" name="contact"><br><br>
		Enter Joining Date 		: <input type="date" name="tempDate" > value="${param.dob}"><br><br>
		Enter Designation 		: <select name="designation"> <option>A<option>B</select><br><br>
								  <input type="submit" value="Update Employee">
					
	</form>
	<a style="color: red">${errorMsg}</a>
</body>
</html>