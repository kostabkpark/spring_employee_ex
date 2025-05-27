package org.example.employee_ex.repository;

import org.example.employee_ex.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  Optional<Employee> findByEmpIdAndEmpName(String empId, String empName);
  List<Employee> findByEmpNameLike(String empName);
  @Query("select e from Employee e join fetch e.department d " +
      "where d.deptId = :deptId")
  List<Employee> findByUserDept(int deptId);
}
