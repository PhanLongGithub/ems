package com.personal.ems.model;

import com.personal.ems.exception.UnAcceptableVariableException;
import com.personal.ems.utils.Constant;
import com.personal.ems.utils.Validations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (Validations.stringValidate(firstName) == true) {
            this.firstName = firstName;
        }
        else throw new UnAcceptableVariableException(firstName + " as firstName is unacceptable");
    }

    public void setLastName(String lastName) {
        if (Validations.stringValidate(lastName) == true) {
            this.lastName = lastName;
        }
        else throw new UnAcceptableVariableException(lastName + " as lastName is unacceptable");
    }

    public void setEmail(String email) {
        if (Validations.stringValidate(email, Constant.EMAIL_REGEX) == true) {
            this.email = email;
        }
        else throw new UnAcceptableVariableException(email + " as email is unacceptable");
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
