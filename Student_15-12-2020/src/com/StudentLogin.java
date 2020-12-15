package com;

import java.io.*;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentLogin extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException {
				
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				
				String studentID = request.getParameter("studentID");
				String password = request.getParameter("password");
				
				if(studentID.equals("161126") && password.equals("kannan"))
					{
					response.sendRedirect("html/Welcome.html");
					}
				else
					out.println("Login Failed");
				
				out.close();
				
			}

}
