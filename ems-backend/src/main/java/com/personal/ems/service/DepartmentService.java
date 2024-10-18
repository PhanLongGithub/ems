package com.personal.ems.service;

import java.util.List;

import com.personal.ems.dto.DepartmentDto;

public interface DepartmentService {
    //CREATE
    public DepartmentDto createDepartment(DepartmentDto departmentDto);

    //READ
    public Long getTotalNumberOfDepartment();
    public List<DepartmentDto> getDepartmentWithPagination(int pageNumber);
    public DepartmentDto getDepartmentById(Long departmentId);
    public List<DepartmentDto> getAllDepartment();

    //UPDATE
    DepartmentDto DepartmentUpdate(Long departmentId, DepartmentDto updatedDepartment);

    //DELETE
    void deleteDepartment(Long departmentId);
}
