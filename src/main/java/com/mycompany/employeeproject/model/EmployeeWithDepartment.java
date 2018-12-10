package com.mycompany.employeeproject.model;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeWithDepartment implements Serializable{
    
    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private String dataOfBirthday;
    private int dep_id;
    private String departmentName;

    public EmployeeWithDepartment() {
    }

    public EmployeeWithDepartment(String surname, String name, String fatherName, String dataOfBirthday, int dep_id, String departmentName) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.dataOfBirthday = dataOfBirthday;
        this.dep_id = dep_id;
        this.departmentName = departmentName;
    }

    public EmployeeWithDepartment(int id, String surname, String name, String fatherName, String dataOfBirthday, int dep_id, String departmentName) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.dataOfBirthday = dataOfBirthday;
        this.dep_id = dep_id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDataOfBirthday() {
        return dataOfBirthday;
    }

    public void setDataOfBirthday(String dataOfBirthday) {
        this.dataOfBirthday = dataOfBirthday;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.fatherName);
        hash = 97 * hash + Objects.hashCode(this.dataOfBirthday);
        hash = 97 * hash + Objects.hashCode(this.departmentName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeWithDepartment other = (EmployeeWithDepartment) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!this.surname.equals(other.surname)) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        if (!this.fatherName.equals(other.fatherName)) {
            return false;
        }
        if (!this.dataOfBirthday.equals(other.dataOfBirthday)) {
            return false;
        }
        if (!this.departmentName.equals(other.departmentName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResponseEmployeeWithDepartment{" + "id=" + id + ", surname=" + surname + ", name=" 
                + name + ", fatherName=" + fatherName + ", dataOfBirthday=" + dataOfBirthday 
                + ", dep_id=" + dep_id + ", departmentName=" + departmentName + '}';
    }
}
