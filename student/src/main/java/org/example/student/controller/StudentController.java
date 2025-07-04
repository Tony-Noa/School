package org.example.student.controller;

import jakarta.validation.Valid;
import org.example.student.dto.StudentReceiveDto;
import org.example.student.dto.StudentResponseDto;
import org.example.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAll(){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }


    @PostMapping
    public ResponseEntity<StudentResponseDto> create (@Valid @RequestBody StudentReceiveDto studentReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(studentReceiveDto));
    }

    @PutMapping("/{id}") //put met une nouvelle donnée
    public ResponseEntity<StudentResponseDto> update (@PathVariable UUID id, @RequestBody StudentReceiveDto studentReceiveDto){
        return ResponseEntity.ok(service.update(id, studentReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("student at id : %s is deleted", id));

    }
}
