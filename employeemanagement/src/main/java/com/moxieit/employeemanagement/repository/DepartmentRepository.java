package com.moxieit.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moxieit.employeemanagement.dao.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
