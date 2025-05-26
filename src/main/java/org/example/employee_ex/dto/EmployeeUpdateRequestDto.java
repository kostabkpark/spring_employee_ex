package org.example.employee_ex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EmployeeUpdateRequestDto {
  private String empName;
  private String department;
}
