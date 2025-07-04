package org.example.subject.controller;

import jakarta.validation.Valid;
import org.example.subject.dto.SubjectReceiveDto;
import org.example.subject.dto.SubjectResponseDto;
import org.example.subject.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class SubjectController {

    private SubjectService service;

    public SubjectController(SubjectService service){
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<SubjectResponseDto>> getAll(){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<SubjectResponseDto> create (@Valid @RequestBody SubjectReceiveDto subjectReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(subjectReceiveDto));
    }

    @PutMapping("/{id}") //put met une nouvelle donnée
    public ResponseEntity<SubjectResponseDto> update (@PathVariable UUID id, @RequestBody SubjectReceiveDto subjectReceiveDto){
        return ResponseEntity.ok(service.update(id, subjectReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("student at id : %s is deleted", id));

    }
}
