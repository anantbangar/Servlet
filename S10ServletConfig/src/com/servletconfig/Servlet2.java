package com.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet 
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
		out.println("<h1>this is for fetch parameters using enumeration </h1>");
		
		ServletConfig scon=getServletConfig();
		String str="";
		Enumeration<String> e=scon.getInitParameterNames();
		
		while(e.hasMoreElements())
		{
			str=e.nextElement();
			out.println("<h3>"+scon.getInitParameter(str)+"</h3>");
		}
		
	}


}
