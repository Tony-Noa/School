package org.example.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class SubjectResponseDto {
    private UUID id;

    private String name;
    private double coeff;
    private UUID teacherId;

}
