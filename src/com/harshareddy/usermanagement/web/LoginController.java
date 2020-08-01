package com.harshareddy.usermanagement.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("inputemail");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher;
		System.out.println("Login Controller POST");
		
		if(username.equalsIgnoreCase("harshar@gmail.com") && password.equalsIgnoreCase("admin")) {
			
			HttpSession session = request.getSession(true);
			 
			session.setAttribute("username", username);		
			requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");
			requestDispatcher.forward(request, response);
			}
		else 
		{
		     requestDispatcher = request.getRequestDispatcher("/admin/signin.jsp");		    
	         request.setAttribute("loginmessage", "Login is Invalid, please login again");
    	     requestDispatcher.include(request, response);

		}
		
		
	}

}
