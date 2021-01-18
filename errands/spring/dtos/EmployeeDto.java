package ru.krisnovitskaya.errandstm.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krisnovitskaya.errandstm.entities.Employee;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private String department;


    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.patronymic = employee.getPatronymic();
        this.position = employee.getPosition();
        this.department = employee.getDepartment().getTitle();
    }
}
