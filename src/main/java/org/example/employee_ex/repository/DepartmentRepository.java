package org.example.employee_ex.repository;

import org.example.employee_ex.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  List<Department> findByDeptName(String deptName);
}
