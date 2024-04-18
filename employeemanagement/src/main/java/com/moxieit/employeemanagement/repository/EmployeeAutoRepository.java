package com.moxieit.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moxieit.employeemanagement.dao.EmployeeAuto;

@Repository
public interface EmployeeAutoRepository  extends JpaRepository<EmployeeAuto, Long>{

}
