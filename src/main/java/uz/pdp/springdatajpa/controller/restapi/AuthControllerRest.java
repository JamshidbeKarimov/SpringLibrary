package uz.pdp.springdatajpa.controller.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springdatajpa.dto.StudentDto;
import uz.pdp.springdatajpa.entity.StudentEntity;
import uz.pdp.springdatajpa.service.StudentService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerRest {

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
