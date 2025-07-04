package org.example.schoolclass.services;

import org.example.schoolclass.dtos.schoolclass.ClassReceiveDto;
import org.example.schoolclass.dtos.schoolclass.ClassResponseDto;
import org.example.schoolclass.models.Class;

import java.util.List;
import java.util.UUID;

public interface ClassService {

    public List<ClassResponseDto> get();
    public ClassResponseDto get(UUID id);
    public ClassResponseDto createClass(ClassReceiveDto classReceiveDto);
    public ClassResponseDto updateClass(UUID id, ClassReceiveDto classReceiveDto);
    public void deleteClass(UUID id);
    public ClassResponseDto toClassDto(Class Class);
    public Class toClass(ClassReceiveDto classReceiveDto);

}
