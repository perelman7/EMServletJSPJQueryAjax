package com.mycompany.employeeproject.model;

import java.util.List;

public class EmployeeDepartmentList {
    
    private List<Employee> employees;
    private List<Department> departments;
    private List<EmployeeWithDepartment> empDeps;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<EmployeeWithDepartment> getEmpDeps() {
        return empDeps;
    }

    public void setEmpDeps(List<EmployeeWithDepartment> empDeps) {
        this.empDeps = empDeps;
    }
}
