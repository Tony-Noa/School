package org.example.schoolclass.models;

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
public class Teacher {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
