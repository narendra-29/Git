<%@page import="com.tbhs.boarding.Employee"%>
<%@page import="com.tbhs.boarding.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee list</title>
</head>
<body bgcolor="gray">
	
	
	
	<h2 align="center">Your Contacts Lists..</h2>
	

	<table width="80%" border="1" style="background-color: gray;" align="center">
				<tr>
					<td style="color: maroon;" bgcolor="gray" align="center"> **Click on ID to Edit Details...** <td>
				</tr>
	</table>
	
	<table width="80%" border="1" style="background-color: teal;" align="center">
    	<%
		    ArrayList<Employee> list1=null;
			list1=(ArrayList<Employee>)request.getAttribute("employeeList");
			int sl=0;
			if(list1!=null)
			{
				%>
					<tr>
		         		<td align="center"> <%= "Sl_no." %> </td>
		                <td> <%= "Id" %> </td>
		                <td> <%= "Name" %> </td>
		                <td> <%= "Contact" %> </td>
		                <td> <%= "Joining Date" %> </td>
		                <td> <%= "Designation" %> </td>
	        		</tr>
				<%
				for (Iterator iterator = list1.iterator(); iterator.hasNext();) 
				{
					Employee bean = (Employee) iterator.next();
					Date dob=bean.getJoiningDate();
					
					%>
                	 <tr>
                 		<td> <%= sl++ %> </td>
	                    <td > <a href="OpenUpdateEmployee.do?id=<%=bean.getId()%>&name=<%=bean.getName()%>&contact=<%=bean.getContact()%>&joinigDate=<%=dob%>&designation=<%=bean.getDesigination()%>"><button style="color: teal; font-style: oblique;font: cursive; " type="button" ><%= bean.getId() %></button></a> </td>
	                    <td> <%=bean.getName()%> </td>
	                    <td> <%=bean.getContact()%> </td>
	                    <td> <%=bean.getJoiningDate()%> </td>
	                    <td> <%=bean.getDesigination()%> </td>	
	                    <td> <a href="DeleteEmployee.do?id=<%=bean.getId()%>&name=<%=bean.getName()%>&contact=<%=bean.getContact()%>&joinigDate=<%=dob%>&designation=<%=bean.getDesigination()%>"><button style="color: red;" type="submit" name="Delete" value="<%= bean.getId() %>">Delete Contact</button></a> </td>	                
                	</tr> 
          		  <% 
				}
			}
		%>
	</table>
	
	
</body>
</html>