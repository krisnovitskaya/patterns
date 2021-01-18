package krisnovitskaya.errands.entities.iterators;

import krisnovitskaya.errands.entities.Department;
import krisnovitskaya.errands.entities.Employee;

import java.util.Stack;

public class SubordinatedEmployeeIterator implements EmployeeIterator{
    private Stack<Employee> allEmployee;

    public SubordinatedEmployeeIterator(Department mainDepartment) {
        this.allEmployee = new Stack<>();

        fillAllEmployee(mainDepartment);
    }

    private void fillAllEmployee(Department dep){
        allEmployee.push(dep.getMaster());
        for (Employee employee : dep.getEmployees()) {
            allEmployee.push(employee);
        }
        fill(dep);
    }
    private void fill(Department dep) {
        if(dep.getDirectlySubordinatedDepartments().size() == 0){

            return;
        }else{
            for (Department department : dep.getDirectlySubordinatedDepartments()) {
                allEmployee.push(department.getMaster());
                for (Employee employee : department.getEmployees()) {
                    allEmployee.push(employee);
                }
                fill(department);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !allEmployee.empty();
    }

    @Override
    public Employee getNext() {
        return allEmployee.pop();
    }
}
