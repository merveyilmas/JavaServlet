package com.httpservlets.com.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BinaryStreamExample
 */
public class BinaryStreamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BinaryStreamExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Setting Response Mime Type
		response.setContentType("image/jpg"); //Mime or media type
		
		//Response Binary Stream
		ServletOutputStream outputStream=response.getOutputStream();
		
		//Read Image Bytes
		
		// 1- Open stream
		InputStream inputStream=getServletContext().getResourceAsStream("images/Chrysanthemum.jpg");
		
		// 2- Define Byte Array
		byte[] imageBytes=new byte[inputStream.available()];
		
		// 3- Read the Image
		inputStream.read(imageBytes);
		
		// 4- Write Image Bytes on Servlet Output Stream
		outputStream.write(imageBytes);
		
		// 5- Flush the response
		outputStream.flush(); //flush means send to response
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
