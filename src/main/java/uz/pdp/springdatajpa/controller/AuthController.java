package uz.pdp.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springdatajpa.dto.StudentDto;
import uz.pdp.springdatajpa.entity.StudentEntity;
import uz.pdp.springdatajpa.repository.StudentRepository;
import uz.pdp.springdatajpa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController{

    private final StudentService studentService;

    @GetMapping
    public StudentEntity signIn(
            @RequestParam String username,
            @RequestParam String password

    ) {
       return studentService.signIn(username, password);
    }

    @PostMapping
    public StudentEntity signUp(@RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

}
