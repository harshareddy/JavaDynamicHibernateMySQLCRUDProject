package com.harshareddy.usermanagement.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harshareddy.usermanagement.dao.DepartmentDAO;
import com.harshareddy.usermanagement.model.Department;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentDAO departmentDAO;

	public DepartmentServlet() {

		super();

		departmentDAO = new DepartmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Department Servlet");
		String action = request.getParameter("action");

		if (action == null) {
			action = "whatever";
		}
		try {
			switch (action) {

			case "list":
				listDepartment(request, response);
				break;
			case "new":
				newDepartment(request, response);
				break;
			case "create":
				createDepartment(request, response);

				break;
			case "delete":
				deleteDepartment(request, response);
				break;
			case "edit":
				editDepartment(request, response);
				break;
			case "update":
				updateDepartment(request, response);
				break;

			default:
				listDepartment(request, response);
				break;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException {
		Department department = new Department();

		department.setId(Integer.parseInt(request.getParameter("id")));
		department.setName(request.getParameter("name"));
		department.setLocation(request.getParameter("country"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = format.parse(request.getParameter("creationdate"));
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		department.setCreationdate(sqlDate);
		departmentDAO.updateDepartment(department);
		response.sendRedirect(request.getContextPath() + "/DepartmentManagement");

	}

	private void createDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException {

		Department department = new Department();

		department.setName(request.getParameter("name"));
		department.setLocation(request.getParameter("country"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = format.parse(request.getParameter("creationdate"));
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		department.setCreationdate(sqlDate);
		departmentDAO.saveDepartment(department);
		response.sendRedirect(request.getContextPath() + "/DepartmentManagement");

	}

	private void editDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Department department;
		int departmentId = Integer.parseInt(request.getParameter("id"));
		department = departmentDAO.getDepartment(departmentId);
		request.setAttribute("department", department);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/department-form.jsp");
		requestDispatcher.forward(request, response);

	}

	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int departmentId = Integer.parseInt(request.getParameter("id"));
		departmentDAO.deleteDepartment(departmentId);
		response.sendRedirect(request.getContextPath() + "/DepartmentManagement");

	}

	private void newDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/department-form.jsp");
		requestDispatcher.forward(request, response);

	}

	private void listDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Department> departmentList = departmentDAO.getAllDepartment();

		request.setAttribute("departmentList", departmentList);

		request.getRequestDispatcher("/admin/department-list.jsp").forward(request, response);

		// response.sendRedirect("department-list.jsp");
	}

}
