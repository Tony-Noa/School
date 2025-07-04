package org.example.student.dto;

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

public class StudentResponseDto {
    private UUID id;

    String last_name;
    String first_name;
    LocalDate birthdate;

}
