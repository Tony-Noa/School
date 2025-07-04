package org.example.student.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.student.dto.StudentResponseDto;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String last_name;
    private String first_name;
    private LocalDate birthdate;

    public StudentResponseDto entityToDto(){
        return StudentResponseDto.builder()
                .id(getId())
                .last_name(getLast_name())
                .first_name(getFirst_name())
                .birthdate(getBirthdate())
                .build();

    }


}
