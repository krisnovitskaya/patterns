package ru.krisnovitskaya.errandstm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.krisnovitskaya.errandstm.entities.Errand;

import java.util.List;

@Repository
public interface ErrandRepository extends JpaRepository<Errand, Long> {
    @Query("select e from Errand e where e.employee.id = ?1")
    List<Errand> getAllByEmployeeId(Long id);

    @Query("select e from Errand e where e.employee.department.id = ?1")
    List<Errand> getAllByDepartmentId(Long id);
}
