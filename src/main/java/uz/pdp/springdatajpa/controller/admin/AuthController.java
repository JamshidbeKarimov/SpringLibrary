package uz.pdp.springdatajpa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springdatajpa.entity.StudentEntity;

@Controller("/auth")
public class AuthController {


    @GetMapping("/sign-in")
    public ModelAndView signIn(@RequestParam String username, @RequestParam String password) {
        StudentEntity student = new StudentEntity();
        student.setName(username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("menu");

        return modelAndView;
    }
}
