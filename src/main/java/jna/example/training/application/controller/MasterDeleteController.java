package jna.example.training.application.controller;

import jna.example.training.domain.service.MasterDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class MasterDeleteController {
    protected final MessageSource messageSource;
    private final MasterDeleteService masterDeleteService;

    /**
     * 拠点解体API
     */
    @GetMapping("/masterDelete/{assigneeId}")
    public String masterDelete(@Valid @PathVariable(name="assigneeId") String assigneeId,
                               RedirectAttributes attributes){

        //削除処理
        masterDeleteService.masterDelete(assigneeId);

        // 画面に表示する属性設定
        attributes.addFlashAttribute("deleteComplete","masterDelete.complete");

        // リダイレクト
        return "redirect:/masterRegister";
    }
}
