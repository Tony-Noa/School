package org.example.schoolclass.services;


import org.example.schoolclass.dtos.schoolclass.ClassReceiveDto;
import org.example.schoolclass.dtos.schoolclass.ClassResponseDto;
import org.example.schoolclass.exeptions.NotFoundException;
import org.example.schoolclass.models.Class;
import org.example.schoolclass.models.Teacher;
import org.example.schoolclass.models.Student;
import org.example.schoolclass.repositories.ClassRepository;
import org.example.schoolclass.util.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class ClassServiceEureka implements ClassService {

    private final RestTemplate restTemplate;
    private final RestClient<Student,UUID> studentRestClient;
    private final RestClient<Teacher,UUID> teacherRestClient;

    private final ClassRepository repository;

    public ClassServiceEureka(RestTemplate restTemplate, ClassRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;

        studentRestClient =  new RestClient<>("http://STUDENT/",this.restTemplate);
        teacherRestClient =  new RestClient<>("http://TEACHER/",this.restTemplate);
    }

    public List<ClassResponseDto> get() {
        return repository.findAll().stream().map(this::toClassDto).toList();
    }

    public ClassResponseDto get(UUID id) {
        return toClassDto(repository.findById(id).orElseThrow(NotFoundException::new));
    }

    public ClassResponseDto createClass(ClassReceiveDto classReceiveDto) {
        return toClassDto(repository.save(toClass(classReceiveDto)));
    }

    public ClassResponseDto updateClass(UUID id, ClassReceiveDto classReceiveDto) {
        return toClassDto(repository.save(toClass(classReceiveDto)));
    }

    public void deleteClass(UUID id) {
        repository.deleteById(id);
    }


    public ClassResponseDto toClassDto(Class Class) {
        return ClassResponseDto.builder()
                .id(Class.getId())
                .students(studentRestClient.get())
                .teacher(teacherRestClient.get(Class.getTeacher(), Teacher.class))
                .build();
    }

    public Class toClass(ClassReceiveDto classReceiveDto) {
        return Class.builder()
                .students(classReceiveDto.getStudents())
                .teacher(classReceiveDto.getTeacher())
                .build();
    }

}
