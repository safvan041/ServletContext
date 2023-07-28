package com.example3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class ServletDemo2 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		System.out.print("doGet method run");
		ServletConfig conf= getServletConfig();
		String param1 = conf.getInitParameter("country");
		String param2 = conf.getInitParameter("city");
		
		ServletContext ctx = getServletContext();
		String driver = (String) ctx.getInitParameter("driver");
		
		pw.print("<center><h2>FROM SERVLETDEMO2</h2></center>");
		pw.print("country name from config:"+param1);
		pw.print("<br>city name from config:"+param2);
		pw.print("<br>Driver name from ctx:"+driver);
	}
	
	public void destroy() {
		System.out.println("obj destroyed");
	}
}