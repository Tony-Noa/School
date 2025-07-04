package org.example.schoolclass.dtos.schoolclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.schoolclass.models.Teacher;
import org.example.schoolclass.models.Student;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassResponseDto {
    private UUID id;
    private List<Student> students;
    private Teacher teacher;
}
