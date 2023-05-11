package com.form;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		System.out.println("this is registration form");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>welcome to registration servlet<h1>");
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String cond=req.getParameter("condition");
		String course=req.getParameter("course");
		
		
		
		if(cond!=null)
		{
				out.println("<h2> name:"+name+"<h2>");
				out.println("<h2> password:"+password+"<h2>");
				out.println("<h2> email:"+email+"<h2>");
				out.println("<h2> gender:"+gender+"<h2>");
				out.println("<h2> course:"+course+"<h2>");
				
				RequestDispatcher rd=req.getRequestDispatcher("success");
				rd.include(req,res);
						
		}
		else
		{
			out.println("<h2>please accept terms and conditions<h2>");
			
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req,res);
		}

	}
}
