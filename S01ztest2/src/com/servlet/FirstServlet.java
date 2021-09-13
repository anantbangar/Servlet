package com.servlet;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;

public class FirstServlet implements Servlet 
{
	ServletConfig confg;
	public void init(ServletConfig confg)
	{
		this.confg =confg;
		System.out.println("creating object...");
	}
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		System.out.println("servicing.....");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>this is my output from servlet<h1>");
		out.println("<h1>todays date "+new Date().toString()+"<h1>");
				
	}
	
	public void destroy()
	{
		System.out.println("destroying object....");
		
	}
	
	public ServletConfig getServletConfig()
	{
		return this.confg;
	}
	
	public String getServletInfo()
	{
		return "servlet is created by anant";
	}

}
