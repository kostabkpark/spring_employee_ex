package org.example.employee_ex.service;


import lombok.extern.slf4j.Slf4j;

import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeResponseDto;
import org.example.employee_ex.dto.EmployeeUpdateRequestDto;
import org.example.employee_ex.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Transactional(readOnly = true)
  public List<EmployeeResponseDto> findAll() {
    List<Employee> doAll = employeeRepository.findAll();
    List<EmployeeResponseDto> dtoAll = doAll.stream().map(e -> new EmployeeResponseDto(e.getEmpId(), e.getEmpName(), e.getDepartment()))
        .collect(Collectors.toList());
    return dtoAll;
  }

  @Transactional(readOnly = true)
  public EmployeeResponseDto findById(String empId) {
    Optional<Employee> byId = employeeRepository.findById(empId);
    if (byId.isPresent()) {
      Employee e = byId.get();
      EmployeeResponseDto employeeDto = new EmployeeResponseDto(e.getEmpId(), e.getEmpName(), e.getDepartment());
      return employeeDto;
    } else {
      return null;
    }
  }

  public EmployeeResponseDto save(EmployeeCreateRequestDto employeeDto) {
    Employee employee = Employee.builder()
        .empId(employeeDto.getEmpId())
        .empName(employeeDto.getEmpName())
        .department(employeeDto.getDepartment())
        .joinDate(employeeDto.getJoinDate())
        .salary(employeeDto.getSalary())
        .build();
    Employee save = employeeRepository.save(employee);
    EmployeeResponseDto saveDto = new EmployeeResponseDto(save.getEmpId(), save.getEmpName(), save.getDepartment());
    return saveDto;
  }

   public EmployeeResponseDto update(String empId,EmployeeUpdateRequestDto employee) {
     // 비즈니스 로직 - 단 empname과 department 가 수정가능함
     Optional<Employee> byId = employeeRepository.findById(empId);
     if(byId.isPresent()) {
       Employee e = byId.get();
       if(employee.getEmpName() != null && !employee.getEmpName().isBlank() ) {
         e.setEmpName(employee.getEmpName());
       }
       e.setDepartment(employee.getDepartment());
       Employee save = employeeRepository.save(e);
       return new EmployeeResponseDto(save.getEmpId(), save.getEmpName(), save.getDepartment());
     } else {
       return null;
     }
   }

  public void delete(String empId) {
    employeeRepository.deleteById(empId);
  }

}
