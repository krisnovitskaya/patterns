package ru.krisnovitskaya.errandstm.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krisnovitskaya.errandstm.entities.Errand;


import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ErrandDto {

    private Long id;
    private String employee;
    private LocalTime createdAt;
    private String status;
    private String matter;
    private LocalTime start;
    private LocalTime end;
    private String place;
    private String comment;
    private String createdBy;
    private String confirmedOrRejectedBy;

    public ErrandDto(Errand errand) {
        this.id = errand.getId();
        this.employee = errand.getEmployee().getFullName();
        this.createdAt = errand.getCreatedAt();
        this.status = errand.getStatus().toString();
        this.matter = errand.getMatter().toString();
        this.start = errand.getStart();
        this.end = errand.getEnd();
        this.place = errand.getPlace();
        this.comment = errand.getComment();
        this.createdBy = errand.getCreatedBy().getFullName();
        this.confirmedOrRejectedBy = errand.getConfirmedOrRejectedBy().getFullName();
    }
}
