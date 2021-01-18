package ru.krisnovitskaya.errandstm.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name= "errands")
@Data
@NoArgsConstructor
public class Errand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "created_at")
    private LocalTime createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "matter")
    @Enumerated(EnumType.STRING)
    private Matter matter;

    @Column(name = "start_at")
    private LocalTime start;

    @Column(name = "end_at")
    private LocalTime end;

    @Column(name = "place")
    private String place;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "confirmed_or_rejected_by_id")
    private Employee confirmedOrRejectedBy;


    public enum Status{
        REQUESTED,
        CONFIRMED,
        REJECTED
    }

    public enum Matter{
        LOCAL,
        PRIVATE,
        LONG
    }
}
