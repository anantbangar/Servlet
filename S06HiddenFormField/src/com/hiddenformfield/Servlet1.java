package com.hiddenformfield;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
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
		
		String name=req.getParameter("user_name");
		
		out.println("<h1> hello "+name+" you are in servlet1</h1>");
		
		out.println(""
				+"<form action='servlet2'>"
				+"<input type='hidden' name='user' value='"+name+"'/>"
				+"<button type='submit'>go to second servlet</button>"
				+"</form>");
		
		
	}

}
