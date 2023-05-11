package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;

public class ShowDBServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<h1>you are in showdb servlet</h1>");
		out.println("<h2>database information is</h2>");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","system123");
			
			out.println("<h2>connection done....</h2>");
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from RFormJDBC");
			
			int id;
			String name="",password="",email="";
			
			while(rs.next())
			{
				/*id=rs.getInt(1);
				name=rs.getString(2);
				password=rs.getString(3);
				email=rs.getString(4);*/
				
				//out.println("<h2> "+id+" "+name+" "+password+" "+email+" </h2>");
				
				out.println("<h2>"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</h2>");
			}
			
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<h2>error....</h2>");
		}
	}

}
