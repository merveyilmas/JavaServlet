package com.servletInitParam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	
	private String companyInitParameters=null;
	private static final long serialVersionUID = 1L;    
    
    @Override
    	public void init(ServletConfig config) throws ServletException {
    		super.init(config);
    		
    		//1-read init param
    		companyInitParameters=config.getInitParameter("company-email");
    	}
    
    public FeedbackServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		printWriter.print("<h2>Init param value is  "+companyInitParameters+"</h2>");
		
		//2-read feedback parameter
		String feedbackParam=request.getParameter("feedbackParam");
		
		//3-send an email
		printWriter.print("<h3> we will send "+feedbackParam+" to "+companyInitParameters+"</h3>");
	}

}
