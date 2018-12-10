package com.mycompany.employeeproject.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable{

    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private String dataOfBirthday;
    private int departmentId;

    public Employee() {
    }

    public Employee(String surname, String name, String fatherName, String dataOfBirthday, int departmentId) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.dataOfBirthday = dataOfBirthday;
        this.departmentId = departmentId;
    }

    public Employee(int id, String surname, String name, String fatherName, String dataOfBirthday, int departmentId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.dataOfBirthday = dataOfBirthday;
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.fatherName);
        hash = 97 * hash + Objects.hashCode(this.dataOfBirthday);
        hash = 97 * hash + this.departmentId;
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
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.departmentId != other.departmentId) {
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
        return true;
    }    
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", dataOfBirthday='" + dataOfBirthday + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
