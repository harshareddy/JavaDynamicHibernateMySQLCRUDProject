package com.harshareddy.usermanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
			HttpSession session = request.getSession(true);
			
			if(session != null) {
			      
			  String userName = 	(String) session.getAttribute("username");
			  
			  if(userName != null)
			  {
				  session.removeAttribute("username");
			  }			  
			  
			}
			  RequestDispatcher requestDispatcher  = request.getRequestDispatcher("/admin/signin.jsp");
			  request.setAttribute("loginmessage", "Logout Succesfull");
			  requestDispatcher.forward(request, response);

	}

}
