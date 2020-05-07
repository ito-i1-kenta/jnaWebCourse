package jna.example.training.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewerController {

    @GetMapping("/viewer")
    public String init(Model model) {
        model.addAttribute("msg",
                "JNA Webアプリ 講座！");
        return "viewer";
    }

    @GetMapping("/viewer/search")
    public String search(Model model) {
        model.addAttribute("msg",
                "JNA Webアプリ 講座！");
        return "viewer";
    }
}
