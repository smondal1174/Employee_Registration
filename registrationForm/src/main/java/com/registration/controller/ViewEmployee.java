package com.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.registration.model.Employee;

@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","bubul123");
    		Statement s=con.createStatement();
    		int result=0;
        	String sql="select * from employee";
    		ResultSet rs=s.executeQuery(sql);
    		List<Employee> ll=new ArrayList<>();
    		while(rs.next()) {
    			Employee obj=new Employee();
    			obj.setFirstName(rs.getString("first_name"));
    			obj.setLastName(rs.getString("last_name"));
    			obj.setUsername(rs.getString("username"));
    			obj.setPassword(rs.getString("password"));
    			obj.setAddress(rs.getString("address"));
    			obj.setContact(rs.getString("contact"));
    			ll.add(obj);
    		}
    		PrintWriter out=response.getWriter(); // [{ }, { }]
			String json=new Gson().toJson(ll);
			out.print(json);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		}
	}



}
