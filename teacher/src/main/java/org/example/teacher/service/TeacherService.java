package org.example.teacher.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(teacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public teacherResponseDto create (teacherReceiveDto teacherReceiveDto){
        return teacherRepository.save(teacherReceiveDto.dtoToEntity()).entityToDto();
    }

    public teacherResponseDto get(UUID id){
        return teacherRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<teacherResponseDto> get(){
        return teacherRepository.findAll().stream().map(teacher::entityToDto).toList();
    }

    public teacherResponseDto update(UUID id, teacherReceiveDto teacherReceiveDto){
        teacher teacherFound = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
        teacher teacherGet = teacherReceiveDto.dtoToEntity();
        teacherFound.setLast_name(teacherGet.getLast_name());
        teacherFound.setFirst_name(teacherGet.getFirst_name());
        teacherFound.setBirthdate(teacherGet.getBirthdate());
        return teacherRepository.save(teacherFound).entityToDto();
    }

    public void delete(UUID id){
        teacherRepository.deleteById(id);
    }
}
