package com.harshareddy.usermanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	int id;

	@Column(name = "emp_name")
	String name;

	@Column(name = "emp_salary")
	int salary;

	@Column(name = "emp_start_date")
	Date startDate;

	@ManyToOne
	Department department;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(String name, int salary, Date startDate, Department department) {
		super();
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
		this.department = department;
	}



	public Employee(int id, String name, int salary, Date startDate, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
		this.department = department;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", startDate=" + startDate
				+ ", department=" + department + "]";
	}
	
	

}
