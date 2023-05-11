package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{
		System.out.println("before servlet");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//out.println("filter is ivoked before");
		
		String name=req.getParameter("user_name");
		if(name.equals("anant") || name.equals("pawan"))
		{
			chain.doFilter(req,res);
		}
		
		else
		{
			out.println("<h2>please enter name as anant or pawan to proceed</h2>");
			
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req,res);
		}
		
		//out.println("filter is ivoked after");
		
		System.out.println("after servlet");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
