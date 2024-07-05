
package com.example.employee_vendor_management.repository;

import com.example.employee_vendor_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   
}
