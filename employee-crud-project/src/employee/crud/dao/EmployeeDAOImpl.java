package employee.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import employee.crud.beans.Employee;
import employee.crud.db.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Connection connection = DBConnection.connection;

	@Override
	public boolean addEmployee(Employee employee) {

		System.out.println("Start addEmployee");

		try {

			String insertStatement = "INSERT INTO atm_ota.employee (name,email,phone) VALUES (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPhone());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		System.out.println("Start updateEmployee");

		try {

			String updateStatement = "UPDATE atm_ota.employee SET name = ?, phone = ?, email = ? WHERE id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPhone());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setInt(4, employee.getId());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		
		
		System.out.println("Start deleteEmployee");
		
		try {
			
			String deleteStatement="DELETE FROM atm_ota.employee WHERE id = ?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setInt(1, employeeId);
					
			int result=preparedStatement.executeUpdate();
			return result==1?  true : false;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		System.out.println("Start Select All Employees");
		
		try {
			
			String selectStatement="SELECT * FROM atm_ota.employee";
			
			PreparedStatement preparedStatement=connection.prepareStatement(selectStatement);
					
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Employee> employees=new ArrayList<Employee>();
			
			while(resultSet.next()) {
				Employee employee=new Employee();
				
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhone(resultSet.getString("phone"));
				
				employees.add(employee);
			}
			return employees;

			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Employee getEmployee(int employeId) {
		
		System.out.println("Start Select Employee");
		
		try {
			
			String selectStatement="SELECT * FROM atm_ota.employee where id = ?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setInt(1, employeId);
					
			ResultSet resultSet=preparedStatement.executeQuery();
			Employee employee=new Employee();
			
			while(resultSet.next()) {
				
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhone(resultSet.getString("phone"));
				
			}
			return employee;

			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(7);
		//employee.setName("MerveYilmaz");
		// employee.setEmail("yilmaz@gmail.com");
		// employee.setPhone("123");

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		// System.out.println(employeeDAOImpl.addEmployee(employee)); //insert
		//System.out.println(employeeDAOImpl.updateEmployee(employee)); //update
		//System.out.println(employeeDAOImpl.deleteEmployee(7)); //delete
		//System.out.println(employeeDAOImpl.getAllEmployes().size()); //select all
		//System.out.println(employeeDAOImpl.getAllEmployes().get(3)); //select all
		System.out.println(employeeDAOImpl.getEmployee(8)); //select one

	}

}
