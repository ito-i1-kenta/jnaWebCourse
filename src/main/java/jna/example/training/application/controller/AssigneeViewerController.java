package jna.example.training.application.controller;

import jna.example.training.application.resource.AssigneeResponse;
import jna.example.training.domain.service.AssigneeService;
import jna.example.training.domain.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class AssigneeViewerController {
    protected final MessageSource messageSource;
    protected final AssigneeService assigneeService;
    protected final RegisterService registerService;

    /*
        画面から受け取る値が未入力、未設定ならnullを設定するためのメソッド
     */
    @InitBinder
    public void initbinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /*
        初期表示
     */
    @GetMapping("/assigneeViewer")
    public String init(@ModelAttribute AssigneeResponse assigneeResponse,
                       Model model) {
        assigneeResponse.setAssigneeEntityList(registerService.getAssigneeList());
        return "assigneeViewer";
    }

}
