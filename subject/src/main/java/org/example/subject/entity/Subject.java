package org.example.subject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.subject.dto.SubjectResponseDto;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private double coeff;
    private UUID teacherId;




    public SubjectResponseDto entityToDto(){
        return SubjectResponseDto.builder()
                .id(id)
                .name(name)
                .coeff(coeff)
                .teacherId(teacherId)
                .build();

    }


}
