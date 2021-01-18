package krisnovitskaya.errands.entities.iterators;

import krisnovitskaya.errands.entities.Employee;

public interface EmployeeIterator {

    boolean hasNext();
    Employee getNext();
}
