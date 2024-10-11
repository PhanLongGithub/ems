package com.personal.ems.service;

import java.util.List;

import com.personal.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDto> getEmployeesWithPagination(int page);
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
    Long getTotalNumberEmployee();
}
