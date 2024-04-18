package com.moxieit.employeemanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moxieit.employeemanagement.dao.Employee;
import com.moxieit.employeemanagement.dao.EmployeeAuto;
import com.moxieit.employeemanagement.repository.EmployeeAutoRepository;
import com.moxieit.employeemanagement.repository.EmployeeRepository;
import com.moxieit.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeAutoRepository employeeAutoRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeAuto save(EmployeeAuto employeeAuto) {
		return employeeAutoRepository.save(employeeAuto);
	}

	@Override
	public List<Employee> fetchEmployeeList() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeByID(Long empID) {

		employeeRepository.deleteById(empID);
	}

	@Override
	public void deleteAutoEmployeeByID(Long empID) {
		employeeAutoRepository.deleteById(empID);
	}

}
