package com.personal.ems.mapper;

import com.personal.ems.dto.DepartmentDto;
import com.personal.ems.model.Department;

public class DepartmentMapper {
    public static DepartmentDto maptoDepartmentDto(Department department){
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription(),
            department.getStatus()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription(),
            departmentDto.getStatus()
        );
    }
}