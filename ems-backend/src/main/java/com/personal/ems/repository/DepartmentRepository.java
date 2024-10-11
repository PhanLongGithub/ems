package com.personal.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.personal.ems.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    String SQL = "SELECT department_id, department_name, department_description, status from departments LIMIT ?1 OFFSET ?2";
    
    @Query(value = SQL, nativeQuery = true)
    public List<Department> getDepartmentWithPagination(int limit, int offset);

    @Query(value = "SELECT COUNT(department_id) FROM departments", nativeQuery = true)
    public Long getTotalDepartment();
}
