package org.example.employee_ex.repository;

import org.example.employee_ex.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
  Optional<Company> findByName(String name);
}
