package ru.krisnovitskaya.errandstm.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krisnovitskaya.errandstm.dtos.EmployeeDto;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "employee_position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



    public String getFullName(){
        return String.format("%s %s %s", surname, name, patronymic);
    }

    public void update(EmployeeDto changedEmployee) {
        setName(changedEmployee.getName());
        setSurname(changedEmployee.getSurname());
        setPatronymic(changedEmployee.getPatronymic());
        setPosition(changedEmployee.getPosition());
    }
}
