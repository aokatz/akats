package ru.job4j.departments;


import java.util.Objects;

/**
 * Department class
 * @author AKats
 */
public class Department implements Comparable<Department> {
    private String departmentName;
    private String serviceName;
    private String divisionName;

    public String getDepartmentName() {
        return departmentName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.serviceName = "";
        this.divisionName = "";
    }

    public Department(String departmentName, String serviceName) {
        this.departmentName = departmentName;
        this.serviceName = serviceName;
        this.divisionName = "";
    }

    public Department(String departmantName, String serviceName, String divisionName) {
        this.departmentName = departmantName;
        this.serviceName = serviceName;
        this.divisionName = divisionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName)
                && Objects.equals(serviceName, that.serviceName)
                && Objects.equals(divisionName, that.divisionName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departmentName, serviceName, divisionName);
    }

    @Override
    public String toString() {
        String result = departmentName;
        if (this.serviceName != "") {
            result += '\\' + serviceName;
        }
        if (this.divisionName != "") {
            result += '\\' + divisionName;
        }
        return result;
    }

    public int compareTo(Department o) {
        if (this.departmentName.equals(o.getDepartmentName())) {
            if (this.serviceName.equals(o.getServiceName())) {
                return this.divisionName.compareTo(o.getDivisionName());
            } else {
                return this.serviceName.compareTo(o.getServiceName());
            }
        }
        return this.departmentName.compareTo(o.getDepartmentName());
    }

}
