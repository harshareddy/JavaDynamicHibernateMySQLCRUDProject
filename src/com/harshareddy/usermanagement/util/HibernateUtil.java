package com.harshareddy.usermanagement.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.harshareddy.usermanagement.model.Department;
import com.harshareddy.usermanagement.model.Employee;
import com.harshareddy.usermanagement.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				settings.put(Environment.URL, "jdbc:sqlserver://localhost\\BVEN00677310A:1433;DatabaseName=hibernatedb");
				settings.put(Environment.USER, "test01");
				settings.put(Environment.PASS, "test1234");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.FORMAT_SQL,"true" );
				// "validate" , "update","create","create-drop"
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Department.class);
				configuration.addAnnotatedClass(Employee.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
