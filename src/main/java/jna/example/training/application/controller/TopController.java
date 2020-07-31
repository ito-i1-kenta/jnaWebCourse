package jna.example.training.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

    /*
        初期表示
     */
    @RequestMapping("/")
    public String init(Model model) {
        // 画面に表示する属性設定
        model.addAttribute("msg",
                "JNA Webアプリ 講座！");

        model.addAttribute("name",
                "TOP");

        // top.htmlの呼び出し
        return "top";
    }
}
