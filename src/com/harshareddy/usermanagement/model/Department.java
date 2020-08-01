package com.harshareddy.usermanagement.model;



import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	int id;
	@Column(name = "department_name")
	String name;
	@Column(name = "department_location")
	String location;
	@Column(name = "create_update_date")	
	Date creationdate;
	
	
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String location, Date creationdate) {
		super();
		this.name = name;
		this.location = location;
		this.creationdate = creationdate;
	}

	public Department(int id, String name, String location, Date creationdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.creationdate = creationdate;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", creationdate=" + creationdate
				+ "]";
	}

}
