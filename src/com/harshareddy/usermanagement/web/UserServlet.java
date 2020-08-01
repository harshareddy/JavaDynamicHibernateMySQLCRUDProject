package com.harshareddy.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harshareddy.usermanagement.dao.UserDAO;
import com.harshareddy.usermanagement.model.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;

	public UserServlet() {
		super();
		userDao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "default";
		}

		System.out.println("UserServlet");
		System.out.println("Action=" + action);

		try {
			switch (action) {
			case "new":
				newuser(request, response);

				break;
			case "insert":
				insertuser(request, response);
				break;
			case "list":
				listUser(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;

			case "edit":
				editUser(request, response);
				break;
			case "update":
				udpateUser(request, response);
				break;

			default:
				listUser(request, response);
				break;
			}

		} catch (Exception e) {
			System.out.println("Exceptin caught:" + e.getMessage());
		}
	}

	private void udpateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();

		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		userDao.updateUser(user);
		response.sendRedirect(request.getContextPath() + "/UserManagement");

	}

	private void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDao.getUserById(id);
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user-form.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect(request.getContextPath() + "/UserManagement");

	}

	private void insertuser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		userDao.saveUser(user);
		response.sendRedirect(request.getContextPath() + "/UserManagement");

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> listUser = userDao.getAllUser();

		request.setAttribute("listUser", listUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user-list.jsp");
		dispatcher.forward(request, response);

	}

	private void newuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("New User");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user-form.jsp");
		dispatcher.forward(request, response);

	}

}
