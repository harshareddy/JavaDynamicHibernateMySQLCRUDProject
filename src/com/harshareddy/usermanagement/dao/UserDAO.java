package com.harshareddy.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.harshareddy.usermanagement.model.User;
import com.harshareddy.usermanagement.util.HibernateUtil;

public class UserDAO {

	public void saveUser(User user) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			System.out.println("Excetion Cauth:" + ex.getMessage());
		}
	}

	public void updateUser(User user) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.update(user);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			System.out.println("Excetion Cauth:" + ex.getMessage());
		}

	}

	public void deleteUser(int id) {

		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
			}
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			System.out.println("Excetion Cauth:" + ex.getMessage());
		}

	}

	public User getUserById(int id) {
		Transaction trans = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			user = session.get(User.class, id);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			System.out.println("Excetion Cauth:" + ex.getMessage());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		Transaction trans = null;
		List<User> userList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();

			userList = session.createQuery("from User").getResultList();
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			System.out.println("Excetion Cauth:" + ex.getMessage());
		}
		return userList;

	}
}
