package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class ThirdServlet extends HttpServlet  
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		System.out.println("this is doGet method of HttpServlet");
		out.println("<h1>this is doGet method of HttpServlet<h1>");
		
		
	}

}
