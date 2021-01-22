package ru.krisnovitskaya.errandstm.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krisnovitskaya.errandstm.entities.Errand;

import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ErrandSimpleDto {

    private Long id;
    private String employee;
    private String status;
    private LocalTime start;
    private LocalTime end;


    public ErrandSimpleDto(Errand errand) {
        this.id = errand.getId();
        this.employee = errand.getEmployee().getFullName();
        this.status = errand.getStatus().toString();
        this.start = errand.getStart();
        this.end = errand.getEnd();
    }
}
