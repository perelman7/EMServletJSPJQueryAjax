package com.mycompany.employeeproject.model;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable{

    private int id;
    private String departmmentName;
    private String description;

    public Department() {
    }

    public Department(String departmmentName, String description) {
        this.departmmentName = departmmentName;
        this.description = description;
    }

    public Department(int id, String departmmentName, String description) {
        this.id = id;
        this.departmmentName = departmmentName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmmentName() {
        return departmmentName;
    }

    public void setDepartmmentName(String departmmentName) {
        this.departmmentName = departmmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.departmmentName);
        hash = 29 * hash + Objects.hashCode(this.description);
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
        final Department other = (Department) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!this.departmmentName.equals(other.departmmentName)) {
            return false;
        }
        if (!this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", departmmentName='" + departmmentName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
