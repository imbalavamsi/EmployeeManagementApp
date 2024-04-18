package com.moxieit.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moxieit.employeemanagement.dao.Department;
import com.moxieit.employeemanagement.dao.Employee;
import com.moxieit.employeemanagement.dao.EmployeeAuto;
import com.moxieit.employeemanagement.repository.DepartmentRepository;
import com.moxieit.employeemanagement.repository.EmployeeAutoRepository;
import com.moxieit.employeemanagement.service.EmployeeService;

/*
 * Employee controller class with CRUD operations
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeAutoRepository employeeAutoRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	// Insert employee details with static information
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute Employee employee) {
		employee.setEmpID(1001L);
		employee.setFirstname("Bala");
		employee.setLastname("Maragani");
		employee.setAddress("Virginia");
		employee.setSalary(100100L);
		employeeService.save(employee);
		return "Successfully saved employee details";
	}

	// Insert employee details with dynamic information
	@PostMapping("/insertDynamicEmployee")
	public Employee insertDynamicEmployee(@RequestBody Employee employee) {
		employee.setEmpID(employee.getEmpID());
		employee.setFirstname(employee.getFirstname());
		employee.setLastname(employee.getLastname());
		employee.setAddress(employee.getAddress());
		employee.setSalary(employee.getSalary());
		Employee employeeObject = employeeService.save(employee);
		return employeeObject;
	}

	// Insert employee details automatically
	@PostMapping("/insertEmployeeAuto")
	public EmployeeAuto insertEmployeeAuto(@RequestBody EmployeeAuto employee) {
		employee.setEmpID(employee.getEmpID());
		employee.setFirstname(employee.getFirstname());
		employee.setLastname(employee.getLastname());
		employee.setAddress(employee.getAddress());
		employee.setSalary(employee.getSalary());
		return employeeService.save(employee);
	}

	// Update employee details with ID automatically
	@PutMapping("/updateEmployeeAuto/{id}")
	public EmployeeAuto updateEmployeeAutoByID(@PathVariable("id") Long id) {
		EmployeeAuto employeAuto = new EmployeeAuto();
		employeAuto.setEmpID(employeAuto.getEmpID());
		employeAuto.setFirstname(employeAuto.getFirstname());
		employeAuto.setLastname(employeAuto.getLastname());
		employeAuto.setAddress(employeAuto.getAddress());
		employeAuto.setSalary(employeAuto.getSalary());
		return employeeService.save(employeAuto);
	}

	// Update employee details with auto increment
	@PutMapping("/updateEmployeeAuto")
	public EmployeeAuto updateEmployeeAuto(@RequestBody EmployeeAuto employeeAuto) {
		return employeeService.save(employeeAuto);
	}

	// Get employee details with ID
	@GetMapping("/getEmployee/{id}")
	public Optional<EmployeeAuto> getEmployee(@PathVariable("id") long id) {
		return employeeAutoRepository.findById(id);
	}

	// Fetch all employee list
	@GetMapping("/fetchEmployeeList")
	public List<Employee> fetchEmployeeList(@ModelAttribute Employee employee) {
		return employeeService.fetchEmployeeList();
	}

	// Delete operation for employee table
	@DeleteMapping("/deleteEmployee/{empID}")
	public String deleteEmployeeByID(@PathVariable("empID") Long empID) {
		employeeService.deleteEmployeeByID(empID);
		return "Deleted Successfully";
	}

	// Delete operation for Employee Auto table
	@DeleteMapping("/deleteAutoEmployee/{empID}")
	public String deleteAutoEmployeeByID(@PathVariable("empID") Long empID) {
		employeeService.deleteEmployeeByID(empID);
		return "Deleted Successfully";
	}

	// Insert Department details with static information
	@PostMapping("/insertDepartment")
	public String insertDepartmentDetails(@ModelAttribute Department department) {
		department.setDepartmentName("Mechanical");
		department.setDepartmentID(104L);
		departmentRepository.save(department);
		return "Department added successfully";
	}

	// Insert Department details with Dynamic information
	@PostMapping("/insertDepartmentDynamic")
	public String insertDepartmentDetailsDynamic(@RequestBody Department department) {
		department.setDepartmentID(department.getDepartmentID());
		department.setDepartmentName(department.getDepartmentName());
		departmentRepository.save(department);
		return "Inserted department details dynamically";
	}

	// Update Department details automatically
	@PutMapping("/updateDepartmentDetails/{deptID}")
	public Department updateDepartmentDetails(@RequestBody Department department, @PathVariable("deptID") Long deptID) {
		department.setDepartmentID(deptID);
		department.setDepartmentName(department.getDepartmentName());
		return departmentRepository.save(department);
	}

	// Get all Department details
	@GetMapping("/getDepartmentList")
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	// Get all Department details
	@GetMapping("/getDepartmentByID/{deptID}")
	public Optional<Department> getDepartmentByID(@PathVariable long deptID) {
		return departmentRepository.findById(deptID);
	}

	// Delete department details
	@DeleteMapping("/deleteDepartmentByID/{deptID}")
	public String deleteDepartmentByID(@PathVariable long deptID) {
		departmentRepository.deleteById(deptID);
		return "Department " + deptID + " deleted successfully";
	}
}
