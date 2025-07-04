package org.example.schoolclass.controllers;

import org.example.schoolclass.dtos.schoolclass.ClassReceiveDto;
import org.example.schoolclass.dtos.schoolclass.ClassResponseDto;
import org.example.schoolclass.services.ClassService;
import org.example.schoolclass.services.ClassServiceEureka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ClassController {


    @Autowired
    private final ClassService classService;

    public ClassController(ClassServiceEureka classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<List<ClassResponseDto>> get() {
        return ResponseEntity.ok(classService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassResponseDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(classService.get(id));
    }

    @PostMapping
    public ResponseEntity<ClassResponseDto> create(@RequestBody ClassReceiveDto classReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.createClass(classReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassResponseDto> update( @PathVariable UUID id,@RequestBody ClassReceiveDto classReceiveDto) {
        return ResponseEntity.ok(classService.updateClass(id,classReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        classService.deleteClass(id);
        return ResponseEntity.ok("Class with id " + id + " Deleted");
    }
}
