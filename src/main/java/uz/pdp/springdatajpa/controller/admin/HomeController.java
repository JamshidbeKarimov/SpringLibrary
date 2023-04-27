package uz.pdp.springdatajpa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/pages/sign-in")
    public String signInView() {
        return "signIn";
    }

    @GetMapping(value = "/pages/sign-up")
    public String signUpView() {
        return "signUp";
    }
}
