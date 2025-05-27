package org.example.employee_ex.domain;

import jakarta.persistence.*;
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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="dept_id")
  private Department department;
  @Column(length = 10)
  private String joinDate;
  private long salary;
}
