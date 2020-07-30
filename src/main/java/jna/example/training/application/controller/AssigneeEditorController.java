package jna.example.training.application.controller;

import jna.example.training.application.resource.AssigneeRequest;
import jna.example.training.domain.service.AssigneeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@AllArgsConstructor
public class AssigneeEditorController {
    protected final MessageSource messageSource;
    protected final AssigneeService assigneeService;

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
    @GetMapping("/assigneeEditor/{id}")
    public String init(@Validated @PathVariable(name = "id") int id,
                       @ModelAttribute AssigneeRequest assigneeRequest,
                       Model model) {
        assigneeRequest.setAssigneeEntity(assigneeService.searchById(id));
        return "assigneeEditor";
    }

    @PostMapping("/assigneeEditor")
    public String edit(@ModelAttribute AssigneeRequest assigneeRequest,
                       BindingResult result, Model model) {
        // バリデーションエラー判定
        if (result.hasErrors()) {
            return "assigneeEditor";
        }

        //更新処理
        assigneeService.edit(assigneeRequest.getAssigneeEntity());

        // 画面に表示する属性設定
        model.addAttribute("complete", messageSource.getMessage("editor.complete", null, Locale.JAPAN));

        return "assigneeEditor";
    }
}
