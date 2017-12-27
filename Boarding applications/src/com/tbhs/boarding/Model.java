package com.tbhs.boarding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class Model 
{
	
	
	public ArrayList<Employee> getEmployeeList() 
	{
		System.out.println("Model >>getEmployeeList() called ");
		Connection con = null;
		PreparedStatement ps_sql = null;
		PreparedStatement ps_ins = null;
		ResultSet rs = null;
		try 
		{
			con=JDBCHelper.getConnection();
			
			if(con==null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else
			{
				ps_sql = con.prepareStatement("SELECT * from  employee");
				ps_sql.execute();
				rs = ps_sql.getResultSet();
				ArrayList<Employee> al=new ArrayList<Employee>();
				while(rs.next())
				{
					Employee bean=new Employee();
					bean.setId(rs.getString("id"));
					bean.setName(rs.getString("name"));
					bean.setContact(rs.getString("contact"));
					bean.setJoiningDate(rs.getString("doj"));
					bean.setDesignation(rs.getString("designation"));
					al.add(bean);
				}
				for (Iterator<Employee> iterator = al.iterator(); iterator.hasNext();) 
				{
					Employee Employee = (Employee) iterator.next();
					System.out.println(Employee);
				}
				return al;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = "+e.getMessage());
		}
		finally 
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(ps_sql);
			JDBCHelper.close(con);
			
		}
	}
	public String saveEmployee(Employee bean) 
	{
		
		System.out.println("Model->saveEmployee() bean = "+bean);
		String validate=bean.validate();
		
		if(validate.equals(Constants.SUCCESS)) 
		{
			Connection con = null;
			PreparedStatement ps_ins_c = null;
			PreparedStatement ps_ins_t = null;
			PreparedStatement ps_ins_p = null;
			ResultSet rs = null;
			ResultSet rskey = null;
			try 
			{
				con=JDBCHelper.getConnection();
				
				if(con==null)
					return "Oops theres been a problem. Cannot connect to DB! Contact Admin!!";
				else
				{
				
					//String query = "INSERT INTO EMPLOYEE( SL_NO, ID, NAME, CONTACT,DOJ, DESIGNATION )VALUES (  '', '', '', , '')"
					
					ps_ins_c = con.prepareStatement("INSERT INTO EMPLOYEE(id,name,contact,doj,DESIGNATION)VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					con.setAutoCommit(false);
					ps_ins_c.setString(1, bean.getId());
					ps_ins_c.setString(2, bean.getName());
					ps_ins_c.setString(3, bean.getContact());
					ps_ins_c.setTimestamp(4, new Timestamp(bean.getJoiningDate().getTime()));
					ps_ins_c.setString(5, bean.getDesigination().toString());
								
					ps_ins_c.addBatch();
					ps_ins_c.executeBatch();
					con.commit();
					System.out.println("new Employee added "+bean);
					return "SUCCESS";
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				try 
				{
					con.rollback();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
					return "Oops something bad happened msg = "+e.getMessage();
				}
				return "Oops something bad happened msg = "+e.getMessage();
			}
			finally 
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(rskey);
				JDBCHelper.close(ps_ins_t);
				JDBCHelper.close(ps_ins_p);
				JDBCHelper.close(ps_ins_c);
				JDBCHelper.close(con);
				System.out.println("finally block closed");
			}
		}
		else
			return validate;
	}

}	


