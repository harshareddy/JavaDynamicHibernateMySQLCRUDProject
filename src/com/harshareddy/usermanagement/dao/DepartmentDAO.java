package com.harshareddy.usermanagement.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.harshareddy.usermanagement.model.Department;
import com.harshareddy.usermanagement.util.HibernateUtil;

public class DepartmentDAO {

	public void saveDepartment(Department department) {

		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(department);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
			trans.rollback();
		}
	}

	public boolean deleteDepartment(int id) {

		Transaction trans = null;
		Department department;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			department = session.get(Department.class, id);

			if (department != null) {
				session.delete(department);
			}

			trans.commit();
            return true;
		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
			trans.rollback();
			return false;
		}
	}

	public void updateDepartment(Department department) {

		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.update(department);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
			trans.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartment() {

		Transaction trans = null;
		List<Department> departmentList = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			departmentList = session.createQuery("From Department").getResultList();
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
			trans.rollback();
		}
		return departmentList;
	}

	public Department getDepartment(int id) {

		Transaction trans = null;
		Department department = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			department = session.get(Department.class, id);
			trans.commit();

		} catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
			trans.rollback();
		}
		return department;
	}

}
