package com.applicationscope.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection connection = null;

	public static Connection openConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver"); // 1. we have to add jar file
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.28:3306/atm_ota", "akilli_mikrofon_db","seZmZcO36LkXJQ76*"); // 2. open the connection

			return connection;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean closeConneciton() {

		try {
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {

		DBConnection dbConnection = new DBConnection();
		System.out.println(dbConnection.openConnection());
	}

}
