package com.tbhs.boarding;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Employee oldBean=null;
    
	public Controller() 
    {
        super();
        System.out.println("in the constructor of Controller Servlet");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in the doGet()");
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in the doPost()");
		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("in the process() of Controller ");
		String uri=request.getRequestURI();
		System.out.println("in the process() of Controller  URI = "+uri);
		Model model = new Model();
		RequestDispatcher rd = null;
		try 
		{
			
			if(uri.equals("/"))
			{
				rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
			}
			
			if(uri.contains("/AddEmployee.do"))
			{
				System.out.println("Request for /AddNewContact.do");
				
				String result = model.saveEmployee((Employee) request.getAttribute("employee"));
				if(result.equals(Constants.SUCCESS))
				{
					PrintWriter pw=response.getWriter();
					
					pw.write("<h3><a href=\"HomePage.jsp\">Contact added successfully click to go to homepage</a></h3>");
				}
				else
				{
					PrintWriter pw=response.getWriter();
					
					pw.write("<h3><a href=\"HomePage.jsp\">Oops domthing worng! \n"+result+"</a></h3>");
				
					System.out.println("error message in controller for /AddNewContact.do = "+result);
					/*request.setAttribute("errorMsg", result);
					rd=request.getRequestDispatcher("/AddContactView.do");
					rd.forward(request, response);*/
				}
				
			}
			
			if(uri.contains("/openAddEmployeeView.do"))
			{
				System.out.println("Request for /openAddEmployeeView.do");
				rd=request.getRequestDispatcher("AddEmployee.jsp");
				rd.forward(request, response);
			
			}

			if(uri.contains("/openListEmployeeView.do"))
			{
				System.out.println("Request for /openUpdateEmployeeView.do");
				ArrayList<Employee> list = model.getEmployeeList();
				
				request.setAttribute("employeeList", list);
				rd=request.getRequestDispatcher("EmployeeListView.jsp");
				rd.forward(request, response);
				return;
				
			}
			if(uri.contains("/OpenUpdateEmployee.do"))
			{
				System.out.println("request for /OpenUpdateEmployee.do");
				
				oldBean=new Employee();
				oldBean.setId(request.getParameter("id"));
				
				System.out.println("OldBean = "+oldBean);
				
				rd=request.getRequestDispatcher("EditEmployee.jsp");
				rd.forward(request, response);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		

}
