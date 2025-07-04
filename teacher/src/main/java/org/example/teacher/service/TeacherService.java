package org.example.teacher.service;


import org.example.teacher.dto.TeacherReceiveDto;
import org.example.teacher.dto.TeacherResponseDto;
import org.example.teacher.entity.Teacher;
import org.example.teacher.exception.NotFoundException;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponseDto create (TeacherReceiveDto teacherReceiveDto){
        return teacherRepository.save(teacherReceiveDto.dtoToEntity()).entityToDto();
    }

    public TeacherResponseDto get(UUID id){
        return teacherRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<TeacherResponseDto> get(){
        return teacherRepository.findAll().stream().map(Teacher::entityToDto).toList();
    }

    public TeacherResponseDto update(UUID id, TeacherReceiveDto teacherReceiveDto){
        Teacher teacherFound = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
        Teacher teacherGet = teacherReceiveDto.dtoToEntity();
        teacherFound.setLast_name(teacherGet.getLast_name());
        teacherFound.setFirst_name(teacherGet.getFirst_name());
        teacherFound.setBirthdate(teacherGet.getBirthdate());
        return teacherRepository.save(teacherFound).entityToDto();
    }

    public void delete(UUID id){
        teacherRepository.deleteById(id);
    }
}
