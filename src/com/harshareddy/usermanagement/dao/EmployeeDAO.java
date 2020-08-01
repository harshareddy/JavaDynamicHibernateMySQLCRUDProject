package com.harshareddy.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.harshareddy.usermanagement.model.Employee;
import com.harshareddy.usermanagement.util.HibernateUtil;

public class EmployeeDAO {

	public void saveEmployee(Employee employee) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(employee);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Cauth:" + e.getMessage());
			trans.rollback();
		}

	}

	public void deleteEmployee(int id) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
			}
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Cauth:" + e.getMessage());
			trans.rollback();
		}

	}

	public void updateEmployee(Employee employee) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.update(employee);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Cauth:" + e.getMessage());
			trans.rollback();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {

		Transaction trans = null;
		List<Employee> employeeList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			employeeList = session.createQuery("From Employee").getResultList();
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Cauth:" + e.getMessage());
			e.printStackTrace();
			trans.rollback();
		}
		return employeeList;
	}

	public Employee getEmployee(int id) {

		Transaction trans = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			employee = session.get(Employee.class, id);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Cauth:" + e.getMessage());
			trans.rollback();
		}
		return employee;
	}

}
