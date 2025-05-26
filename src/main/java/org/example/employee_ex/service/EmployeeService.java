package org.example.employee_ex.service;


import lombok.extern.slf4j.Slf4j;

import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeReponseDto;
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
  public List<EmployeeReponseDto> findAll() {
    List<Employee> doAll = employeeRepository.findAll();
    List<EmployeeReponseDto> dtoAll = doAll.stream().map(e -> new EmployeeReponseDto(e.getEmpId(), e.getEmpName(), e.getDepartment()))
        .collect(Collectors.toList());
    return dtoAll;
  }

  public EmployeeReponseDto findById(String empId) {
    Optional<Employee> byId = employeeRepository.findById(empId);
    if (byId.isPresent()) {
      Employee e = byId.get();
      EmployeeReponseDto employeeDto = new EmployeeReponseDto(e.getEmpId(), e.getEmpName(), e.getDepartment());
      return employeeDto;
    } else {
      return null;
    }
  }

  public EmployeeReponseDto save(EmployeeCreateRequestDto employeeDto) {
    Employee employee = Employee.builder()
        .empId(employeeDto.getEmpId())
        .empName(employeeDto.getEmpName())
        .department(employeeDto.getDepartment())
        .joinDate(employeeDto.getJoinDate())
        .salary(employeeDto.getSalary())
        .build();
    Employee save = employeeRepository.save(employee);
    EmployeeReponseDto saveDto = new EmployeeReponseDto(save.getEmpId(), save.getEmpName(), save.getDepartment());
    return saveDto;
  }

  @Transactional
  public Employee update(Employee employee) {return null;}
  @Transactional
  public void delete(int id) {}

}
