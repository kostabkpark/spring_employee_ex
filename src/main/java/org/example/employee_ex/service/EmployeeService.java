package org.example.employee_ex.service;


import lombok.extern.slf4j.Slf4j;

import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

@Service
@Slf4j
@Transactional(readOnly = true)
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

//  public List<Employee> findAll() {
//    return null;
//  }
  public Employee findById(int id) {return null;}

  @Transactional
  public Employee save(EmployeeCreateRequestDto employeeDto) {
    Employee employee1 = new Employee();
    employee1.setEmpId(employeeDto.getEmpId());

    Employee employee = Employee.builder()
        .empId(employeeDto.getEmpId())
        .empName(employeeDto.getEmpName())
        .department(employeeDto.getDepartment())
        .joinDate(employeeDto.getJoinDate())
        .salary(employeeDto.getSalary())
        .build();
    return null;
  }

  @Transactional
  public Employee update(Employee employee) {return null;}
  @Transactional
  public void delete(int id) {}

}
