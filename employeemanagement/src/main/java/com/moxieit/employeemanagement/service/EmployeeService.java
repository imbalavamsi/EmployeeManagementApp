package com.moxieit.employeemanagement.service;

import java.util.List;

import com.moxieit.employeemanagement.dao.Employee;
import com.moxieit.employeemanagement.dao.EmployeeAuto;
public interface EmployeeService {

	Employee save(Employee employee);
	
	EmployeeAuto save(EmployeeAuto employeeAuto);
	
	List<Employee> fetchEmployeeList();

	void deleteEmployeeByID(Long empID);
	
	void deleteAutoEmployeeByID(Long empID);
	
}
