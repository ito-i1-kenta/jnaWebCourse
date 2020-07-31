package jna.example.training.application.controller;

import jna.example.training.application.resource.MasterRegisterRequest;
import jna.example.training.application.resource.MasterViewerResponse;
import jna.example.training.application.resource.MasterViewerResponseResource;
import jna.example.training.domain.service.MasterRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class MasterRegisterController {

    protected final MessageSource messageSource;
    private final MasterRegisterService masterRegisterService;

    @InitBinder
    public void initbinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    /*
        初期表示
     */
    @GetMapping("/masterRegister")
    public String init(@ModelAttribute  MasterRegisterRequest masterRegisterRequest,
                       @ModelAttribute MasterViewerResponse masterViewerResponse, Model model) {

        //情報取得
        List<MasterViewerResponseResource> list = masterRegisterService.search();

        //レスポンス値の設定
        masterViewerResponse.factory(list);

        // 画面に表示する属性設定
        model.addAttribute("name",
                "拠点新築");

        // top.htmlの呼び出し
        return "masterRegister";
    }

    /**
     * 拠点建築API
     */
    @PostMapping("/masterRegister")
    public String masterRegister(@Validated @ModelAttribute MasterRegisterRequest masterRegisterRequest, BindingResult result, @ModelAttribute MasterViewerResponse masterViewerResponse, Model model){

        // バリデーションエラー判定
        if(result.hasErrors()){
            return "masterRegister";
        }
        masterRegisterService.masterRegister(masterRegisterRequest);

        //情報取得
        List<MasterViewerResponseResource> list = masterRegisterService.search();

        //レスポンス値の設定
        masterViewerResponse.factory(list);

        // 画面に表示する属性設定
        model.addAttribute("name",
                "拠点新築");

        // 画面に表示する属性設定
        model.addAttribute("complete",
                messageSource.getMessage("masterRegister.complete", null, Locale.JAPAN));

        return "masterRegister";
    }

    /**
     * 拠点情報一覧API
     */
    @GetMapping("/master/search")
    public String search(@ModelAttribute MasterViewerResponse masterViewerResponse, Model model){

        //情報取得
        List<MasterViewerResponseResource> list = masterRegisterService.search();

        //レスポンス値の設定
        masterViewerResponse.factory(list);


        model.addAttribute("name",
                "拠点改造");


        return "master/";
    }



}