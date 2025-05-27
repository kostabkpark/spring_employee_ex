package org.example.employee_ex.repository;

import org.example.employee_ex.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  Optional<Employee> findByEmpIdAndEmpName(String empId, String empName);
  List<Employee> findByEmpNameLike(String empName);
  @Query("select e from Employee e join fetch e.department d ")     //"where d.deptId = :deptId")
  List<Employee> findByUserDept(int deptId);

  @Query("select e from Employee e join fetch e.department d")
  List<Employee> findByUserAllDept();

  // String jpql = "select e from Employee e " ; // select * from employee ;
//   List<Employee> emps = em.createQuery(jpql, Employee.class).getResultList();
  // jpql / fetch join (연관관계가 있는 객체까지 한번에 가져오는 쿼리)
//  String fetchjpql = "select e from Employee e join fetch e.department";
//  List<Employee> emps = em.createQuery(fetchjpql, Employee.class).getResultList();
}
