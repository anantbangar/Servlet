package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<h1> you are in RegisterServlet1 <h1>");
						
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		
		out.println("<h2>your information is<h2>");
		out.println("<h2>id :-"+id+"<h2>");
		out.println("<h2>name :-"+name+"<h2>");
		out.println("<h2>password :-"+password+"<h2>");
		out.println("<h2>email :-"+email+"<h2>");
		
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","system123");
			
			System.out.println("connection done");
			out.println("<h2>connection done<h2>");
			
			PreparedStatement pstmt=con.prepareStatement("insert into RFormJDBC values(?,?,?,?)");
			
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,password);
			pstmt.setString(4,email);
			
			pstmt.executeUpdate();
			
			con.close();
			
			System.out.println("insertion is done....");
			out.println("<h2>insertion is done....<h2>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<h2>error.....<h2>");
		}
		
		out.println("<h2> to see database information click on show link<h2>");
		out.println("<a href='showdb'>show database info</a>");
		
		
	}
	
		


}
