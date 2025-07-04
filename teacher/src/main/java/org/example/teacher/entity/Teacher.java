package org.example.teacher.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.teacher.dto.TeacherResponseDto;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="teacher")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String last_name;
    private String first_name;
    private LocalDate birthdate;

    public TeacherResponseDto entityToDto(){
        return TeacherResponseDto.builder()
                .id(getId())
                .last_name(getLast_name())
                .first_name(getFirst_name())
                .birthdate(getBirthdate())
                .build();

    }


}
