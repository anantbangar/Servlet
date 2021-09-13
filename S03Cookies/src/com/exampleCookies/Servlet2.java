package com.exampleCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet 
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
		
		Cookie cookies[]=req.getCookies();
		
		String name=" ";
		int flag=0;
		
		if(cookies==null)
		{
			out.println("<h1> you are new user go to home page and enter your name <h1>");
			return;
		}
		
		else
		{
			/*for(Cookie c:cookies)
			{
				String tempname=c.getName();
				if(tempname.equals("user_name"))
				{
					flag=1;
					name=c.getValue();
				}
			}*/
			
			for(int i=0;i<cookies.length;i++)
			{
				String tempname=cookies[i].getName();
				if(tempname.equals("user_name"))
				{
					flag=1;
					name=cookies[i].getValue();
				}
			}
		}
		
		if(flag==1)
		{
			out.println("<h1>hello "+name+" welcome back to this web site<h1>");
		}
		
		
		
	}
}
