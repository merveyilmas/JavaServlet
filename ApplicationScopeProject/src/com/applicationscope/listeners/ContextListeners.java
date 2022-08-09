package com.applicationscope.listeners;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.applicationscope.db.DBConnection;

public class ContextListeners implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("Hi, Application is stopped");
		
		boolean isClosed=DBConnection.closeConneciton();
		System.out.println("DB connection is closed? "+isClosed);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("Hi, Application is started");
		
		ServletContext servletContext=sce.getServletContext();
		
		Connection connection=DBConnection.openConnection();
		servletContext.setAttribute("db-connection", connection);
		
		System.out.println(connection);
		System.out.println("Connection is established!");
	}

}
