package org.example.employee_ex.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeResponseDto;
import org.example.employee_ex.dto.EmployeeUpdateRequestDto;
import org.example.employee_ex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  public EmployeeResponseDto createEmployee(@RequestBody EmployeeCreateRequestDto employeeDto) {
    log.info("employeeDto : {}", employeeDto);
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

  @GetMapping("/dept/{deptId}")
  public List<EmployeeResponseDto> getAllEmpDept(@PathVariable("deptId") int deptId) {
    return employeeService.findByEmpDept(deptId);
  }

  @PutMapping("/{empId}")
  public EmployeeResponseDto updateDepartment(@PathVariable String empId,
                                              @RequestBody EmployeeUpdateRequestDto updateRequestDto) {
    return employeeService.update(empId, updateRequestDto);
  }

  @DeleteMapping("/{empId}")
  public void deleteEmployee(@PathVariable String empId) {
    employeeService.delete(empId);
  }
}
