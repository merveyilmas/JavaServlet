package employee.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import employee.crud.beans.Employee;
import employee.crud.dao.EmployeeDAO;
import employee.crud.dao.EmployeeDAOImpl;

@WebServlet("/")
public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO=null;
       
  
    public EmployeeController() {
        super();
      
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	employeeDAO=new EmployeeDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Add 
		//Update
		//Delete
		//Select
		
		System.out.println("EmployeeController, doPost method Started");
		
		String action=request.getServletPath();
		System.out.println("doPost, action==>"+action);
		
		switch (action) {
		case "/add": {
			addNewEmployee(request,response);
			break;
		}
		case "/update":{
			updateEmployee(request,response);
			break;
		}
		case "/delete":{
			deleteEmployee(request,response);
			break;
		}			
		case "/list":{
			getAllEmployee(request,response);
			break;
		}			
		case "/get":{
			getEmployee(request,response);
			break;
		}
		default:
			getAllEmployee(request,response);
			break;
		}
	}

	private void getEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Start getEmployee");
		
		int id=Integer.parseInt(request.getParameter("employeeId"));
		
		System.out.println("getEmployee, Employee ID ==>"+id);
		
		Employee employee = employeeDAO.getEmployee(id);
		System.out.println("getEmployee, result is ==>" + employee);
		
		
		try {
			//converting java object to json or you can do viceversa
			ObjectMapper mapper = new ObjectMapper();
			String employeeStr = mapper.writeValueAsString(employee);
			
			ServletOutputStream servletOutputStream =response.getOutputStream();
			servletOutputStream.write(employeeStr.getBytes());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Start getAllEmployee");
		
		List<Employee> employees=employeeDAO.getAllEmployees();
		System.out.println("getAllEmployee, result is ==>"+employees.size());
		
		//int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println("getAllEmployee, Employee ID==>"+id);
		
		try {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
			
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Start deleteEmployee");
		
		String employeeIds=request.getParameter("employeeIds");
		System.out.println("deleteEmployee, Employee ID==>"+employeeIds);
		
		StringTokenizer tokenizer = new StringTokenizer(employeeIds, ",");
		
		while(tokenizer.hasMoreElements()) 
		{
			int employeeId = Integer.parseInt(tokenizer.nextToken());
			boolean result=employeeDAO.deleteEmployee(employeeId);
			System.out.println("deleteEmployee, result is ==>"+result);
		}
		
		List<Employee> employees=employeeDAO.getAllEmployees();
		System.out.println("getAllEmployee, employee size ==>"+employees.size());
		
		
		try {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
			
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Start updateEmployee");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		
		Employee employee=new Employee(id,name,email,phone);
		
		System.out.println("updateEmployee, Employee Details==>"+employee);
		
		boolean result=employeeDAO.updateEmployee(employee);
		System.out.println("updateEmployee, result is ==>"+result);
		
		List<Employee> employees=employeeDAO.getAllEmployees();
		System.out.println("getAllEmployee, employee size ==>"+employees.size());
		
		try {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
			
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {


		System.out.println("Start addNewEmployee");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		Employee employee=new Employee(name,email,phone);
		System.out.println("addNewEmployee, Employee Details==>" + employee);
		
		boolean result=employeeDAO.addEmployee(employee);
		System.out.println("addNewEmployee, result is ==>" + result);
		
		List<Employee> employees=employeeDAO.getAllEmployees();
		System.out.println("getAllEmployees, employees size ==>" + employees.size());
		
		
		try {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
			
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
