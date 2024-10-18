package com.personal.ems.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.ems.dto.DepartmentDto;
import com.personal.ems.exception.ResourceNotFoundException;
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
        departmentDto.setStatus(true);
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
        List<DepartmentDto> departmentDtos = departments.stream().map(
            (department) -> {return DepartmentMapper.maptoDepartmentDto(department); 
            }).toList();
        return departmentDtos; 
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> {
            return new ResourceNotFoundException("Can't find department with Id: " + departmentId);
        });
        return DepartmentMapper.maptoDepartmentDto(department);
    }

    @Override
    public DepartmentDto DepartmentUpdate(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> {
            return new ResourceNotFoundException("Can't find department with Id: " + departmentId);
        });
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        return DepartmentMapper.maptoDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> {
            return new ResourceNotFoundException("Can't find department with Id: " + departmentId);
        });
        department.setStatus(false);
        departmentRepository.save(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.getAllDepartment();
        List<DepartmentDto> departmentDtos = departments.stream().map(
            (department) -> {return DepartmentMapper.maptoDepartmentDto(department); 
            }).toList();
        return departmentDtos;
    }
}
