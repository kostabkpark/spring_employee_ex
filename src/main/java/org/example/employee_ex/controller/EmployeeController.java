package org.example.employee_ex.controller;

import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeResponseDto;
import org.example.employee_ex.dto.EmployeeUpdateRequestDto;
import org.example.employee_ex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public EmployeeResponseDto createEmployee(@RequestBody EmployeeCreateRequestDto employeeDto) {
    EmployeeResponseDto save = employeeService.save(employeeDto);
    return save;
  }

  @GetMapping
  public List<EmployeeResponseDto> getAllEmployees() {
    return employeeService.findAll();
  }

  @GetMapping("/{empId}")
  public EmployeeResponseDto getEmployee(@PathVariable String empId) {
    return employeeService.findById(empId);
  }

  @PutMapping("/{empId}")
  public EmployeeResponseDto updateDepartment(@PathVariable EmployeeUpdateRequestDto updateRequestDto) {
    employeeService.update(updateRequestDto);
  }
}
