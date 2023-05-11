package com.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet1 extends HttpServlet
{	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		processRequest(req,res);
	}
	
	public void processRequest(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<h2>this is demoservlet1</h2>");
		
		ServletContext sctx=getServletContext();
		
		sctx.setAttribute("company_name","HP");
									
		out.println("<a href='DemoServlet2' target='_blank'>go to demoservlet2</a>");
				
		
	}
}
