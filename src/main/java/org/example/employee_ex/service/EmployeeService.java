package org.example.employee_ex.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.employee_ex.domain.Department;
import org.example.employee_ex.domain.Employee;
import org.example.employee_ex.dto.EmployeeCreateRequestDto;
import org.example.employee_ex.dto.EmployeeResponseDto;
import org.example.employee_ex.dto.EmployeeUpdateRequestDto;
import org.example.employee_ex.repository.CompanyRepository;
import org.example.employee_ex.repository.DepartmentRepository;
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
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;
  private final CompanyRepository companyRepository;

  @Transactional(readOnly = true)
  public List<EmployeeResponseDto> findAll() {
    List<Employee> doAll = employeeRepository.findAll();
    List<EmployeeResponseDto> dtoAll = doAll.stream().map(
        e -> new EmployeeResponseDto(
            e.getEmpId(),
            e.getEmpName(),
            e.getDepartment() != null ? e.getDepartment().getDeptName() : "부서정보없음"))
        .collect(Collectors.toList());
    return dtoAll;
  }

  @Transactional(readOnly = true)
  public EmployeeResponseDto findById(String empId) {
    Optional<Employee> byId = employeeRepository.findById(empId);
    if (byId.isPresent()) {
      Employee e = byId.get();
      EmployeeResponseDto employeeDto = new EmployeeResponseDto(
          e.getEmpId(),
          e.getEmpName(),
          e.getDepartment() != null ? e.getDepartment().getDeptName() : "부서정보없음");
      return employeeDto;
    } else {
      return null;
    }
  }

  public List<EmployeeResponseDto> findByEmpDept(int deptId) {
    List<Employee> byUserDept = employeeRepository.findByUserDept(deptId);
    List<EmployeeResponseDto> dtoAll = byUserDept.stream().map(
            e -> new EmployeeResponseDto(
                e.getEmpId(),
                e.getEmpName(),
                e.getDepartment() != null ? e.getDepartment().getDeptName() : "부서정보없음"))
        .collect(Collectors.toList());
    return dtoAll;
  }

  public EmployeeResponseDto save(EmployeeCreateRequestDto employeeDto) {
    Department dept = departmentRepository.findById(employeeDto.getDeptId()).orElse(null);
    Employee employee = Employee.builder()
        .empId(employeeDto.getEmpId())
        .empName(employeeDto.getEmpName())
        .department(dept)
        .joinDate(employeeDto.getJoinDate())
        .salary(employeeDto.getSalary())
        .build();
    Employee save = employeeRepository.save(employee);
    EmployeeResponseDto saveDto = new EmployeeResponseDto(save.getEmpId(), save.getEmpName(), save.getDepartment().getDeptName());
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
       e.setDepartment(departmentRepository.findById(employee.getDeptId()).orElse(null));
       Employee save = employeeRepository.save(e);
       return new EmployeeResponseDto(save.getEmpId(), save.getEmpName(), save.getDepartment().getDeptName());
     } else {
       return null;
     }
   }

  public void delete(String empId) {
    employeeRepository.deleteById(empId);
  }

}
