package jna.example.training.application.controller;

import jna.example.training.application.resource.EditorResponseResource;
import jna.example.training.application.resource.MasterEditorRequest;
import jna.example.training.application.resource.MasterEditorResource;
import jna.example.training.application.resource.MasterEditorResponseResource;
import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import jna.example.training.domain.object.EmpNo;
import jna.example.training.domain.service.MasterEditorService;
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
public class MasterEditorController {
    protected final MessageSource messageSource;
    private MasterEditorService masterEditorService;

    /**
     * 画面から受け取る値が未入力、未設定ならnullを設定するためのメソッド
     */
    @InitBinder
    public void initbinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
    }

    /**
     * 初期表示
     */
    @GetMapping("/masterEditor/{assigneeId}")
    public String init(@Validated @PathVariable(name = "assigneeId") String assigneeId,
                       @ModelAttribute MasterEditorRequest masterEditorRequest,
                       Model model){

        // 検索処理
        MasterEditorResponseResource resource = masterEditorService.searchById(AssigneeId.of(assigneeId));

        //レスポンス値の設定
        masterEditorRequest.factory(resource);

        // 画面に表示する属性設定
        model.addAttribute("name",
                "改築");

        // editor.htmlの呼び出し
        return "masterEditor";
    }

    @PostMapping("masterEditor")
    public String masterEditor(@Validated @ModelAttribute MasterEditorRequest masterEditorRequest,
                               BindingResult result,
                               Model model){

        if(result.hasErrors()){
            return "masterEditor";
        }

        MasterEditorResource resource = MasterEditorResource.masterEdit(
                AssigneeId.of(masterEditorRequest.assigneeId),
                AssigneeName.of(masterEditorRequest.assigneeName)
        );

        //更新処理
        masterEditorService.masterEditor(resource);

        // 画面に表示する属性設定
        model.addAttribute("name", "改築");
        model.addAttribute("complete", messageSource.getMessage("masterUpdate.complete", null, Locale.JAPAN));

        return "masterEditor";

    }

}
