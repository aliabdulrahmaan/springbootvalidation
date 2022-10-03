package com.aliassad.springbootvalidation.SpringbootValidation.service;


import com.aliassad.springbootvalidation.SpringbootValidation.controller.errors.BadRequestAlertException;
import com.aliassad.springbootvalidation.SpringbootValidation.domain.Employee;
import com.aliassad.springbootvalidation.SpringbootValidation.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee e){
        return  employeeRepository.save(e);
    }

    public Employee update(Employee e){
        return  employeeRepository.save(e);
    }

    @Transactional(readOnly = true)
    public Employee findById(Long id){
        return  employeeRepository.findById(id).orElseThrow(()->
                new BadRequestAlertException("There is No employee with this Id","Employee","IdNotFound"));
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll(){
        return  employeeRepository.findAll();
    }



    public void delete(Long id){
          employeeRepository.deleteById(id);
    }
}
