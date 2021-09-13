package com.filterconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter
{
	FilterConfig fcon;
	
	public void init(FilterConfig fcon)throws ServletException
	{
		this.fcon=fcon;
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String str=fcon.getInitParameter("construction");
		
		if(str.equals("yes"))
		{
			out.println("<h1> page is under construction <h1>");
		}
		
		else
		{
			chain.doFilter(req,res);
		}
		
	}
}
