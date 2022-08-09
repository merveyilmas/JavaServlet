package com.sessionscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionScopeExample
 */
public class SessionScopeExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionScopeExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		
		//request.getCookies(); //==> JSESSIONID (cookie name)
		HttpSession httpSession=request.getSession(); //Get User Session
		
		Object sessionObject=httpSession.getAttribute("isVisited");
		
		if(sessionObject==null) { //if null, this is the first visited for user
			
			httpSession.setAttribute("isVisited", true); //Add Attribute 
			//Attribute : server-side
			//Cookie : client-side
			printWriter.print("Thanks for visiting our application");
		}else {
			
			printWriter.print("Welcome back..");
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
