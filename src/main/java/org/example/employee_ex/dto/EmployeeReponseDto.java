package org.example.employee_ex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeReponseDto {
  private String empId;
  private String empName;
  private String department;
}
