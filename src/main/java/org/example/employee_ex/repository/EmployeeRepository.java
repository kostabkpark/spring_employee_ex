package org.example.employee_ex.repository;

import org.example.employee_ex.domain.Employee;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  Optional<Employee> findByIdAndEmpName(String empId, String empName);
  List<Employee> findByEmpNameLike(String empName);
}
