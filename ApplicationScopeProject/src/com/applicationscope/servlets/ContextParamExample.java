package com.applicationscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamExample
 */
public class ContextParamExample extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		config.getServletContext();	
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContextParamExample() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		ServletContext servletContext=request.getServletContext();
		
		printWriter.print("<h2>Context Parameters</h2><br/>");
		printWriter.print("<h3>DB ip: "+servletContext.getInitParameter("db-ip")+"</h3>");
		printWriter.print("<h3>DB port: "+servletContext.getInitParameter("db-port")+"</h3>");
		
		Enumeration<String> enumeration=servletContext.getInitParameterNames();
		//loop
		

		//request.getServletContext(); 	// 1. method to reach context parameters
		//getServletContext(); 			// 2. method to reach context parameters
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
