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
import com.harshareddy.usermanagement.dao.EmployeeDAO;
import com.harshareddy.usermanagement.model.Department;
import com.harshareddy.usermanagement.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO;
	DepartmentDAO departmentDAO;

	public EmployeeServlet() {
		super();
		employeeDAO = new EmployeeDAO();
		departmentDAO = new DepartmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {

			action = "list";
		}

		switch (action) {
		case "list":

			listEmployee(request, response);

			break;
		case "new":
			newEmployee(request, response);
			break;
		case "create":
			try {
				createEmployee(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "edit":
			editEmployee(request, response);

			break;
		case "delete":
			deleteEmployee(request, response);
			break;
		case "update":
			try {
				updateEmployee(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:

			listEmployee(request, response);
			break;
		}

	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.deleteEmployee(id);
		response.sendRedirect(request.getContextPath() + "/EmployeeManagement");

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {

		Employee employee = new Employee();
		Department department = null;
		employee.setId(Integer.parseInt(request.getParameter("id")));
		employee.setName(request.getParameter("name"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = format.parse(request.getParameter("startdate"));
		java.sql.Date sqlStartDate = new java.sql.Date(parseDate.getTime());
		employee.setStartDate(sqlStartDate);
		int departmentId = Integer.parseInt(request.getParameter("department"));
		department = departmentDAO.getDepartment(departmentId);
		employee.setDepartment(department);
		employeeDAO.updateEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/EmployeeManagement");
		// This does not work have to investigate why
		/*
		 * RequestDispatcher requestDispatcher =
		 * request.getRequestDispatcher("/EmployeeManagement");
		 * requestDispatcher.forward(request, response);
		 */

	}

	private void editEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee employee;
		List<Department> departmentList = departmentDAO.getAllDepartment();
		employee = employeeDAO.getEmployee(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("employee", employee);
		request.setAttribute("departmentList", departmentList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/employee-form.jsp");
		requestDispatcher.forward(request, response);

	}

	private void createEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {
		Employee employee = new Employee();
		Department department = null;
		System.out.println(request.getParameter("salary"));
		employee.setName(request.getParameter("name"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = format.parse(request.getParameter("startdate"));
		java.sql.Date sqlStartDate = new java.sql.Date(parseDate.getTime());
		employee.setStartDate(sqlStartDate);
		int departmentId = Integer.parseInt(request.getParameter("department"));
		department = departmentDAO.getDepartment(departmentId);
		employee.setDepartment(department);
		employeeDAO.saveEmployee(employee);

		response.sendRedirect(request.getContextPath() + "/EmployeeManagement");
		// does not work investigate why
		/*
		 * RequestDispatcher requestDispatcher =
		 * request.getRequestDispatcher("/EmployeeManagement");
		 * requestDispatcher.forward(request, response);
		 */

	}

	private void newEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Department> departmentList = departmentDAO.getAllDepartment();
		request.setAttribute("departmentList", departmentList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/employee-form.jsp");
		requestDispatcher.forward(request, response);

	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Employee> employeeList = employeeDAO.getAllEmployee();
		request.setAttribute("employeeList", employeeList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/employee-list.jsp");

		requestDispatcher.forward(request, response);

	}

}
