package com.firstServletApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstHttpServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/*@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printwriter=res.getWriter();
		printwriter.print("<h1>Hello from http servlet!!</h1>");
		printwriter.print("<h1>today is:"+new Date(0)+"</h1>");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter printwriter=res.getWriter();
		printwriter.print("<h1>Hello from doGet http servlet!!</h1>");
		printwriter.print("<h1>today is:"+new Date(0)+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter printwriter=res.getWriter();
		printwriter.print("<h1>Hello from doPost http servlet!!</h1>");
		printwriter.print("<h1>today is:"+new Date(0)+"</h1>");
	}

}
