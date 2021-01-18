package krisnovitskaya.errands.entities.iterators;

import krisnovitskaya.errands.entities.Department;
import krisnovitskaya.errands.entities.Employee;

import java.util.Stack;

public class MasterIterator implements EmployeeIterator {
    private final Stack<Department> stack;

    public MasterIterator(Department mainDepartment) {
        this.stack = new Stack<>();
        fillStack(mainDepartment);
    }


    private void fillStack(Department dep){
        if(dep.getDirectlySubordinatedDepartments().size() == 0){
            return;
        }else{
            for (Department subDep : dep.getDirectlySubordinatedDepartments()) {
                stack.push(subDep);
                fillStack(subDep);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public Employee getNext() {
        Department dep = stack.pop();
        return dep.getMaster();
    }
}
