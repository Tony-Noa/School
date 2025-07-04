package org.example.teacher.controller;

import jakarta.validation.Valid;

import org.example.teacher.dto.TeacherReceiveDto;
import org.example.teacher.dto.TeacherResponseDto;
import org.example.teacher.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("")
public class TeacherController {

    private TeacherService service;

    public TeacherController(TeacherService service){
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<TeacherResponseDto>> getAll(){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<TeacherResponseDto> create (@Valid @RequestBody TeacherReceiveDto teacherReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(teacherReceiveDto));
    }

    @PutMapping("/{id}") //put met une nouvelle donnée
    public ResponseEntity<TeacherResponseDto> update (@PathVariable UUID id, @RequestBody TeacherReceiveDto teacherReceiveDto){
        return ResponseEntity.ok(service.update(id, teacherReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("teacher at id : %s is deleted", id));

    }
}
