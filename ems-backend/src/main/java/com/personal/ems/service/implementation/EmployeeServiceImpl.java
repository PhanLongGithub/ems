package com.personal.ems.service.implementation;

import java.util.List;
import java.util.stream.*;
import org.springframework.stereotype.Service;

import com.personal.ems.dto.EmployeeDto;
import com.personal.ems.exception.ResourceNotFoundException;
import com.personal.ems.mapper.EmployeeMapper;
import com.personal.ems.model.Employee;
import com.personal.ems.repository.EmployeeRepository;
import com.personal.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(
            (employee) -> {
            EmployeeDto dto = EmployeeMapper.maptoEmployeeDto(employee);
            return dto;
        }).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee successUpdatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(successUpdatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        employeeRepository.deleteById(employee.getId());
    }

    @Override
    public List<EmployeeDto> getEmployeesWithPagination(int page) {
        List<Employee> employees = employeeRepository.getEmployeeWithPagination(10, (page - 1)*10);
        List<EmployeeDto> employeeDtos = employees.stream().map(
            (employee) -> {
            EmployeeDto dto = EmployeeMapper.maptoEmployeeDto(employee);
            return dto;
        }).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public Long getTotalNumberEmployee() {
        return employeeRepository.getTotalEmployee();
    }

}
