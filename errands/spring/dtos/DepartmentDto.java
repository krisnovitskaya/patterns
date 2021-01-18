package ru.krisnovitskaya.errandstm.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krisnovitskaya.errandstm.entities.Department;
import ru.krisnovitskaya.errandstm.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String title;
    private String master;
    private List<String> employees;


    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.title = department.getTitle();
        this.master = department.getMaster().getFullName();
        this.employees = department.getEmployees().stream().map(Employee::getFullName).collect(Collectors.toList());
    }
}
