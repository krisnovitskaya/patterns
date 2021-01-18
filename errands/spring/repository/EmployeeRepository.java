package ru.krisnovitskaya.errandstm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.krisnovitskaya.errandstm.entities.Employee;


import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.department.id = ?1")
    List<Employee> getAllByDepartmentId(Long id);
}
