package com.firstServletApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	ServletConfig config=null;
	
	//1-
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		
	}
	
	//2-
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printwriter=res.getWriter();
		printwriter.print("<h1>Hello!!</h1>");
		printwriter.print("<h1>today is:"+new Date(0)+"</h1>");
	}
	
	//3-
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//4-
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	//5-
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
