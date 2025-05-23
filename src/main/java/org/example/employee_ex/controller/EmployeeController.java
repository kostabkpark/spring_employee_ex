package org.example.employee_ex.controller;

import jakarta.persistence.Access;
import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public Employee createEmployee(@RequestBody EmployeeCreateRequestDto employeeDto) {
    Employee save = employeeService.save(employeeDto);
    return save;
  }

}
