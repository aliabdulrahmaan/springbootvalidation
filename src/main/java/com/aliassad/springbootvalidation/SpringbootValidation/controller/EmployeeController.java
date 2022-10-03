package com.aliassad.springbootvalidation.SpringbootValidation.controller;


import com.aliassad.springbootvalidation.SpringbootValidation.domain.Employee;
import com.aliassad.springbootvalidation.SpringbootValidation.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee e){
        Employee result = employeeService.create(e);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@Valid @RequestBody Employee e){
        Employee result = employeeService.create(e);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee result = employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> result= employeeService.findAll();
        return result;
    }


    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }
}
