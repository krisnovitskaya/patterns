package krisnovitskaya.errands.entities.iterators;

public interface Subordinate {
    EmployeeIterator createMasterIterator();
    EmployeeIterator createAllSubordinatedIterator();
}
