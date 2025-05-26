package org.example.employee_ex.controller;

import jakarta.persistence.Access;
import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeReponseDto;
import org.example.employee_ex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public EmployeeReponseDto createEmployee(@RequestBody EmployeeCreateRequestDto employeeDto) {
    EmployeeReponseDto save = employeeService.save(employeeDto);
    return save;
  }

  @GetMapping
  public List<EmployeeReponseDto> getAllEmployees() {
    return employeeService.findAll();
  }

  @GetMapping("/{empId}")
  public EmployeeReponseDto getEmployee(@PathVariable String empId) {
    return employeeService.findById(empId);
  }
}
