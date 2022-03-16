package com.registration.controller;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.dao.EmployeeDao;


@WebServlet("/delete")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeDao emp;
    public void init() {
    	emp=new EmployeeDao();
    }
    public EmployeeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employeedelete.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			int id=Integer.parseInt(request.getParameter("id"));
			emp.deleteEmployee(id);
			out.println("<h1>Employee Successfully deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		
		
	}

}
