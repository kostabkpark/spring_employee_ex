package org.example.employee_ex.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.example.employee_ex.domain.Employee;

@Data
public class EmployeeCreateRequestDto {
  private String empId;
  private String empName;
  private int deptId;
  private String joinDate;
  private long salary;
}
