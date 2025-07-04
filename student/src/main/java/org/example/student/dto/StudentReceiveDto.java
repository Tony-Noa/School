package org.example.student.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.student.entity.Student;
import org.example.student.repository.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentReceiveDto {

    private String last_name;
    private String first_name;

    @Pattern(regexp= "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private String birthdate;

    public Student dtoToEntity() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Student.builder()
                .last_name(getLast_name())
                .first_name(getFirst_name())
                .birthdate(LocalDate.parse(getBirthdate(), dateTimeFormatter))
                .build();
    }


}
