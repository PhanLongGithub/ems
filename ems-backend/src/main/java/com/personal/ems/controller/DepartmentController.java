package com.personal.ems.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.ems.dto.DepartmentDto;
import com.personal.ems.service.DepartmentService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/total-number")
    public ResponseEntity<Long> getTotalNumberOfDepartment(){
        return ResponseEntity.ok(departmentService.getTotalNumberOfDepartment());
    }

    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<List<DepartmentDto>> getDepartmentListWithPagination(@PathVariable("pageNumber") int pageNumber){
        return ResponseEntity.ok(departmentService.getDepartmentWithPagination(pageNumber));
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartment) {
        return ResponseEntity.ok(departmentService.DepartmentUpdate(departmentId, updatedDepartment));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Successfully delete department");
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    
}
