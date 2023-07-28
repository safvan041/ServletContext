package com.example3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class ServletDemo extends HttpServlet
{
	ServletConfig conf;
	public void init (ServletConfig conf)
	{
		this.conf=conf;
		System.out.println("init run");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		System.out.print("doGet method run");
		String param1 = conf.getInitParameter("country");
		String param2 = conf.getInitParameter("city");
		
		ServletContext ctx = conf.getServletContext();
		String driver = (String)ctx.getInitParameter("driver");
		
		pw.print("<center><h2>welcome to our site</h2></center>");
		pw.print("country name from config:"+param1);
		pw.print("<br> city name from config:"+param2);
		pw.print("<br> driver name from ctx");
		pw.print("<br<a href='s2'>SecondServlet</a>");
	}
	
	public void destroy()
	{
		System.out.println("obj destroyed");
	}
}