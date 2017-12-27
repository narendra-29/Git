package com.tbhs.boarding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee 
{
	private String id;
	private String name;
	private String contact;
	private String tempDate;
	private Date joiningDate;
	private Designation designation;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("id");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("name");
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		System.out.println("contact");
		this.contact = contact;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		System.out.println("joiningDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		try {
				this.joiningDate = sdf.parse(joiningDate);
			} catch (ParseException e) {
				e.printStackTrace();
		}
	}

	public void setTempDate(String tempDate) {
		this.tempDate =tempDate;
		setJoiningDate(tempDate);
	}
	public String getTempDate() {
		return tempDate;
	}
	public Designation getDesigination() {
		return designation;
	}

	public void setDesignation(String designation) {
		System.out.println("designation");
		this.designation = Designation.valueOf(designation);
	}

	public String validate() 
	{
		StringBuffer sb=new StringBuffer();
		if(name==null||name.trim().equals(""))
			sb.append("Name is Mandatory.<br>");
		if(id==null||id.trim().equals(""))
			sb.append("Id is not proper.<br>");
		if(joiningDate== null)
			sb.append("joiningDate is Mandatory.<br>");
		if(designation==null)
			sb.append("desigination is Mandatory.<br>");
		if(contact==null||contact.trim().equals(""))
			sb.append("contact nums is Mandatory.<br>");
		if(sb.toString().equals(""))
			return Constants.SUCCESS;
		else
			return sb.toString();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", contact=" + contact + ", tempDate=" + tempDate
				+ ", joiningDate=" + joiningDate + ", designation=" + designation + "]";
	}
	
	
	
	
	
}
