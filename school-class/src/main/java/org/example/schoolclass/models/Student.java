package org.example.schoolclass.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student{
    private UUID id;
    private String first_name;
    private String last_name;
    private LocalDate birthdate;
}
