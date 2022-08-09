package com.httprequestexample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTTPServletRequestExample
 */
public class HTTPServletRequestExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTTPServletRequestExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter printWriter=response.getWriter();
		
		//REquest Object content : HTTP REquest object which sent from web browser: Header+Body (Parameters)
		 
		//1- Locale : Language ==> Response depend on the locale
		printWriter.print("<h1>Request Locale : "+request.getLocale()+"</h1>");
		
		//2- Content Length 
		printWriter.print("<h1>Request Content Length : "+request.getContentLength()+"</h1>");
		
		//3- Server Name
		printWriter.print("<h1>Request Server Name : "+request.getServerName()+"</h1>");
		
		//4- Content Type (Mime Type, Data Type) = request object
		printWriter.print("<h1>Request Content Type : "+request.getContentType()+"</h1>");
		
		//5- Context Path =for reach object or file which in the application
		printWriter.print("<h1>Request Context Path : "+request.getContextPath()+"</h1>");
		
		//6- Parameter
		printWriter.print("<h1>User Name Parameter : "+request.getParameter("userName")+"</h1>");
		printWriter.print("<h1>Country Parameter : "+request.getParameter("country")+"</h1>");
		request.getParameterNames(); //we can learn to parameters names
		
		//and we have more that like request..... these are some
	}

}
