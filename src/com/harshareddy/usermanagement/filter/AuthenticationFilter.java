package com.harshareddy.usermanagement.filter;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String requestURI = req.getRequestURI();
		String signinURI = req.getContextPath() + "/admin/signin.jsp";
		String LoginControllerURI = req.getContextPath() + "/LoginController";
		String assetsURI =req.getContextPath()+"/assets";
		HttpSession session = req.getSession(true);
		String userName = (String) session.getAttribute("username");

		System.out.println("requestURI:" + requestURI);
		System.out.println("signinURI:" + signinURI);
		System.out.println("LoginControllerURI:" + LoginControllerURI);
		System.out.println("userName:" + userName);

		if ( userName != null) {

			chain.doFilter(request, response);
		} else {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/admin/signin.jsp");
			requestdispatcher.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
