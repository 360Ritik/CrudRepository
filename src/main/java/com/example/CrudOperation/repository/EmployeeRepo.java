package com.example.CrudOperation.repository;

import com.example.CrudOperation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
