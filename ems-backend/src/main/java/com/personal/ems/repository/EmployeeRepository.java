package com.personal.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.personal.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    String SQL = "SELECT employee_id, first_name, last_name, email_id from employees e LIMIT ?1 OFFSET ?2";
    
    @Query(value = SQL, nativeQuery = true)
    public List<Employee> getEmployeeWithPagination(int limit, int offset);

    @Query(value = "SELECT COUNT(employee_id) FROM employees", nativeQuery = true)
    public Long getTotalEmployee();
}
