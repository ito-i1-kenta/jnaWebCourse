package jna.example.training.application.controller;

import jna.example.training.application.resource.AssigneeResponse;
import jna.example.training.domain.service.AssigneeService;
import jna.example.training.domain.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
@AllArgsConstructor
public class AssigneeDeleteController {
    protected final MessageSource messageSource;
    protected final AssigneeService assigneeService;
    protected final RegisterService registerService;

    /*
        削除処理API
     */
    @GetMapping("/assigneeDelete/{id}")
    public String init(@Validated @PathVariable(name = "id") int id,
                       @ModelAttribute AssigneeResponse assigneeResponse,
                       Model model) {
        // 削除処理
        assigneeService.delete(id);

        // 画面に表示する属性設定
        model.addAttribute("complete", messageSource.getMessage("delete.complete", null, Locale.JAPAN));
        assigneeResponse.setAssigneeEntityList(registerService.getAssigneeList());

        return "assigneeViewer";
    }
}
