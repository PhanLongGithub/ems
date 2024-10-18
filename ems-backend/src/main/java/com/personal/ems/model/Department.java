package com.personal.ems.model;

import com.personal.ems.exception.UnAcceptableVariableException;
import com.personal.ems.utils.Validations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;

    @Column
    private Boolean status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        if (Validations.stringValidate(departmentName) == true) {
            this.departmentName = departmentName;
        }else throw new UnAcceptableVariableException(departmentName + " as department name is unacceptable");
    }

    public void setDepartmentDescription(String departmentDescription) {
        if (Validations.stringValidate(departmentDescription) == true) {
            this.departmentDescription = departmentDescription;
        }else throw new UnAcceptableVariableException(departmentDescription + " as department description is unacceptable");
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}
