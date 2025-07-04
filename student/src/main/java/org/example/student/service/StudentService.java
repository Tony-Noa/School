package org.example.student.service;

import org.example.student.dto.StudentReceiveDto;
import org.example.student.dto.StudentResponseDto;
import org.example.student.entity.Student;
import org.example.student.exception.NotFoundException;
import org.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto create (StudentReceiveDto studentReceiveDto){
        return studentRepository.save(studentReceiveDto.dtoToEntity()).entityToDto();
    }

    public StudentResponseDto get(UUID id){
        return studentRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<StudentResponseDto> get(){
        return studentRepository.findAll().stream().map(Student::entityToDto).toList();
    }

    public StudentResponseDto update(UUID id, StudentReceiveDto studentReceiveDto){
        Student studentFound = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        Student studentGet = studentReceiveDto.dtoToEntity();
        studentFound.setLast_name(studentGet.getLast_name());
        studentFound.setFirst_name(studentGet.getFirst_name());
        studentFound.setBirthdate(studentGet.getBirthdate());
        return studentRepository.save(studentFound).entityToDto();
    }

    public void delete(UUID id){
        studentRepository.deleteById(id);
    }
}
