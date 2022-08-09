package com.applicationscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScopeServlet2
 */
public class ApplicationScopeServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ServletContext servletContext=null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		servletContext=config.getServletContext();
		//servletContext=getServletContext(); //we can also use this method
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScopeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		Connection connection=(Connection)servletContext.getAttribute("db-connection");
		
		printWriter.print("<h1> Employee DB Object is Obtained from Context "+connection+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
