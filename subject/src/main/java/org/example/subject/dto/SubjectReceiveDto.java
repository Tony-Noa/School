package org.example.subject.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.subject.entity.Subject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectReceiveDto {

    private String name;
    private double coeff;
    private UUID teacherId;


    public Subject dtoToEntity() {
        return Subject.builder()
                .name(getName())
                .coeff(getCoeff())
                .teacherId(getTeacherId())
                .build();
    }


}
