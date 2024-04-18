package com.moxieit.employeemanagement.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@Column( name = "departmentid")
	private long departmentID;
	
	@Column( name = "departmentname")
	private String departmentName;

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
