package jna.example.training.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String init(Model model) {
        model.addAttribute("msg",
                "JNA Webアプリ 講座！");
        return "register";
    }

}
