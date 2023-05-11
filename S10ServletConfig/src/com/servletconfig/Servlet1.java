package com.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<h1>This is servlet1 for Servlet Config example </h1>");
		out.println("<h1>this is for fetch only one parameter </h1>");
		
		ServletConfig scon=getServletConfig();
		String driverName=scon.getInitParameter("driver");
		String url=scon.getInitParameter("url");
		out.println("<h3> driver name is : "+driverName+"</h3>");
		out.println("<h3> url pattern is : "+url+"</h3>");
		
	}


}
