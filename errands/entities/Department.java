package krisnovitskaya.errands.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String title;
    private Employee master;
    private List<Employee> employees;
    private List<Department> directlySubordinatedDepartments;

    public List<Department> getDirectlySubordinatedDepartments() {
        return directlySubordinatedDepartments;
    }

    public void setDirectlySubordinatedDepartments(List<Department> directlySubordinatedDepartments) {
        this.directlySubordinatedDepartments = directlySubordinatedDepartments;
    }

    public Department() {
        employees = new ArrayList<>();
        directlySubordinatedDepartments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getMaster() {
        return master;
    }

    public void setMaster(Employee master) {
        this.master = master;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
