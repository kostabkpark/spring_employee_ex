package org.example.employee_ex.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@Builder
public class Employee {
  @Id
  private String empId;
  @Column(length = 20, nullable = false)
  private String empName;
  @Column(length = 20)
  private String department;
  @Column(length = 10)
  private String joinDate;
  private long salary;
}
