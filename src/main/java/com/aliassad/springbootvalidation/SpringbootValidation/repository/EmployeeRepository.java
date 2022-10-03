package com.aliassad.springbootvalidation.SpringbootValidation.repository;


import com.aliassad.springbootvalidation.SpringbootValidation.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
