package org.example.employee_ex.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dept")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int deptId;
  @Column(length = 10)
  private String deptName;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="id")
  private Company company;
}
