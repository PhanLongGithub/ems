package com.personal.ems.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.ems.dto.DepartmentDto;
import com.personal.ems.mapper.DepartmentMapper;
import com.personal.ems.model.Department;
import com.personal.ems.repository.DepartmentRepository;
import com.personal.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImplement implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.maptoDepartmentDto(savedDepartment);
    }

    @Override
    public Long getTotalNumberOfDepartment() {
        return departmentRepository.getTotalDepartment();
    }

    @Override
    public List<DepartmentDto> getDepartmentWithPagination(int pageNumber) {
        List<Department> departments = departmentRepository.getDepartmentWithPagination(10, (pageNumber - 1) *10);
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentById'");
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentById'");
    }

    @Override
    public DepartmentDto DepartmentUpdate(Long departmentId, DepartmentDto updatedDepartment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DepartmentUpdate'");
    }

    @Override
    public void deleteDepartment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDepartment'");
    }
}
