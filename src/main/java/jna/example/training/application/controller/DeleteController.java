package jna.example.training.application.controller;

import jna.example.training.domain.service.DeleteService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class DeleteController {

    protected final MessageSource messageSource;
    protected final DeleteService deleteService;

    /*
        社員情報削除API
     */
    @GetMapping("/delete/{empNo}")
    public String delete(@Valid @PathVariable(name = "empNo") @Pattern(regexp = "[0-9]{6}") String empNo,
                         RedirectAttributes attributes) {

        // Todo 削除処理
        deleteService.delete(empNo);

        // 画面に表示する属性設定
        attributes.addFlashAttribute("complete", messageSource.getMessage("delete.complete", null, Locale.JAPAN));

        // リダイレクトでviewer.htmlの呼び出し
        return "redirect:/viewer";
    }

}
