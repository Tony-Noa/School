package org.example.subject.service;

import org.example.subject.dto.SubjectReceiveDto;
import org.example.subject.dto.SubjectResponseDto;
import org.example.subject.entity.Subject;
import org.example.subject.exception.NotFoundException;
import org.example.subject.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public SubjectResponseDto create (SubjectReceiveDto studentReceiveDto){
        return subjectRepository.save(studentReceiveDto.dtoToEntity()).entityToDto();
    }

    public SubjectResponseDto get(UUID id){
        return subjectRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<SubjectResponseDto> get(){
        return subjectRepository.findAll().stream().map(Subject::entityToDto).toList();
    }

    public SubjectResponseDto update(UUID id, SubjectReceiveDto subjectReceiveDto){
        Subject subjectFound = subjectRepository.findById(id).orElseThrow(NotFoundException::new);
        Subject subjectGet = subjectReceiveDto.dtoToEntity();
        subjectFound.setName(subjectGet.getName());
        subjectFound.setCoeff(subjectGet.getCoeff());
        subjectFound.setTeacherId(subjectGet.getTeacherId());

        return subjectRepository.save(subjectFound).entityToDto();
    }

    public void delete(UUID id){
        subjectRepository.deleteById(id);
    }
}
