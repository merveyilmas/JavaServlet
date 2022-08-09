package com.applicationscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScopeServlet1
 */
public class ApplicationScopeServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScopeServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		
		try {
			
			/*Class.forName("com.mysql.jdbc.Driver"); // 1. we have to add jar file
			Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.0.28:3306/atm_ota","akilli_mikrofon_db","seZmZcO36LkXJQ76*"); // 2. open the connection
			
			printWriter.print("<h2> Employee DB Connection Object: "+connection+"</h2>");
			
			getServletContext().setAttribute("employee-connection-db", connection);*/
			
		}catch(Exception e) {
			e.printStackTrace();
			
			printWriter.print("<h2> Exception is opening connection to Employee DB: "+e.getMessage()+"</h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
