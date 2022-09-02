package employee.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String dbURL="jdbc:mysql://192.168.0.28:3306/atm_ota";
	public static final String dbUserName="akilli_mikrofon_db";
	public static final String dbPassword="seZmZcO36LkXJQ76*";
	
	
	public static Connection getConnection() {
		
		System.out.println("Start getConnection"); // logger: Log4j
		
		try {
			//load MySql JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open Connection
			connection=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
			
			if(connection!=null) {
				System.out.println("Connected!");
				return connection;
			}else {
				System.out.println("Connection Issue");
				return null;
			}
			
		}catch(Exception e) {
			System.out.println("Exc eption in DB Connection==>"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public static Connection connection=getConnection();
	
	public static void main(String[] args) {
		
		System.out.println(DBConnection.connection);
	}
}
