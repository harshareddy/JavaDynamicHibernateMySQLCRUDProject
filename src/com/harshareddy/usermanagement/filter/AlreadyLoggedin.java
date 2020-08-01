package com.harshareddy.usermanagement.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AlreadyLoggedin
 */
public class AlreadyLoggedin implements Filter {

    /**
     * Default constructor. 
     */
    public AlreadyLoggedin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		String userName = (String) session.getAttribute("username");
		
		System.out.println("AlreadyLoggedIn Filter");
		
		if(userName != null)
		{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/index.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else {
			chain.doFilter(request, response);
		}

	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
