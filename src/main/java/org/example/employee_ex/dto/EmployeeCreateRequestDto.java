package org.example.employee_ex.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeCreateRequestDto {
  private String empId;
  private String empName;
  private String department;
  private String joinDate;
  private long salary;
}
