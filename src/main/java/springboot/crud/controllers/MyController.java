package springboot.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @GetMapping("/")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping(value = {"/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }
}