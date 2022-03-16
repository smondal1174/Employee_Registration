package com.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.dao.EmployeeDao;
import com.registration.model.Employee;


@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao emp;
	 public void init() {
	        emp = new EmployeeDao();
	    }
   
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    try {
	    	String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String contact=request.getParameter("contact");
			
			Employee e=new Employee();
			e.setFirstName(firstName);
			e.setLastName(lastName);
			e.setUsername(username);
			e.setPassword(password);
			e.setAddress(address);
			e.setContact(contact);
			
			emp.registerEmployee(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
	    
	}

}
