package jna.example.training.application.controller;

import jna.example.training.application.resource.AssigneeResponse;
import jna.example.training.domain.service.AssigneeService;
import jna.example.training.domain.service.RegisterService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
@AllArgsConstructor
public class AssigneeRegisterController {
    protected final MessageSource messageSource;
    protected final AssigneeService assigneeService;
    protected final RegisterService registerService;

    /*
        登録処理API
     */
    @PostMapping("/assigneeRegister")
    public String register(@Param("insert") String insert,
                           @ModelAttribute AssigneeResponse assigneeResponse,
                           Model model) {

        // 登録処理
        assigneeService.save(insert);

        // 画面に表示する属性設定
        model.addAttribute("complete", messageSource.getMessage("register.complete", null, Locale.JAPAN));
        assigneeResponse.setAssigneeEntityList(registerService.getAssigneeList());

        return "assigneeViewer";
    }
}
