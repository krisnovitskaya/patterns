package ru.krisnovitskaya.errandstm.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "master_id")
    private Employee master;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}


