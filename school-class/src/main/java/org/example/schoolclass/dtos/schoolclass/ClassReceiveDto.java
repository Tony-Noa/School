package org.example.schoolclass.dtos.schoolclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassReceiveDto {
    private List<UUID> students;
    private UUID teacher;
}
