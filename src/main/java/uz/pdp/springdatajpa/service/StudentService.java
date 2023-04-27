package uz.pdp.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.springdatajpa.dto.StudentDto;
import uz.pdp.springdatajpa.entity.StudentEntity;
import uz.pdp.springdatajpa.exception.DataNotFoundException;
import uz.pdp.springdatajpa.exception.WrongCredentialsException;
import uz.pdp.springdatajpa.repository.StudentRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentEntity create(StudentDto studentDto) {
        return studentRepository.save(modelMapper.map(studentDto, StudentEntity.class));
    }

    public StudentEntity signIn(String username, String password) {
        StudentEntity studentEntity = studentRepository.findStudentEntitiesByUsername(username)
                .orElseThrow(() -> {
                    throw new WrongCredentialsException("wrong username and/or password");
                });

        if(Objects.equals(studentEntity.getPassword(), password)) {
            return studentEntity;
        }

        throw new WrongCredentialsException("wrong username and/or password");
    }
}
