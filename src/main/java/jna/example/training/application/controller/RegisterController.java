package jna.example.training.application.controller;

import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.RegisterResource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.RegisterService;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.entity.PrefecturesEntity;
import jna.example.training.infrastructure.entity.SexEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@AllArgsConstructor
public class RegisterController {

    protected final MessageSource messageSource;
    private final RegisterService registerService;

    /**
     * 画面から受け取る値が未入力、未設定ならnullを設定するためのメソッド
     */
    @InitBinder
    public void initbinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**
     * 初期表示
     */
    @GetMapping("/register")
    public String init(@ModelAttribute RegisterRequest registerRequest, Model model) {
        // register.htmlの呼び出し
        model.addAttribute("name",
                "社員登録情報");

        return "register";
    }

    /**
     * 社員情報登録API
     */
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute RegisterRequest registerRequest,
                           BindingResult result, Model model) {
        // バリデーションエラー判定
        if (result.hasErrors()) {
            return "register";
        }



        RegisterResource resource = RegisterResource.create(
                EmpNo.of(registerRequest.empNo),
                UserName.of(registerRequest.userName),
                Password.of(registerRequest.password),
                BirthDate.of(registerRequest.birthDate),
                SexId.of(registerRequest.sex),
                BirthPlaceId.of(registerRequest.birthPlace),
                NickName.of(registerRequest.nickName),
                AssigneeId.of(registerRequest.assignee),
                Photo.of(registerRequest.photo)
        );

        // 登録処理
        registerService.register(resource);

        // 画面に表示する属性設定

        model.addAttribute("complete",
                messageSource.getMessage("register.complete", null, Locale.JAPAN));



        return "register";
    }

    /**
     * 画像アップロード（ここは興味があれば見る程度でOK）
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("files") List<MultipartFile> files, @ModelAttribute RegisterRequest registerRequest, Model model) {
        StringBuffer data = new StringBuffer();
        try {
            String base64 = new String(Base64.getEncoder().encode(files.get(0).getBytes()));
            data.append("data:image/jpeg;base64,");
            data.append(base64);
            model.addAttribute("photo", data.toString());
        } catch (Exception ex) {

        }

        return data.toString();
    }

    /**
     * プロフィール画像初期値
     */
    @ModelAttribute("photo")
    public String photoInit(Model model) {
        return "/images/square-image.png";
    }

    /**
     * 性別リスト
     */
    @ModelAttribute("sexItemList")
    public List<SexEntity> sexItemList() {
        return registerService.getSexList();
    }

    /**
     * 出身地リスト
     */
    @ModelAttribute("birthPlaceList")
    public List<PrefecturesEntity> birthPlaceList() {
        return registerService.getPrefecturesList();
    }

    /**
     * 配属先リスト
     */
    @ModelAttribute("assigneeList")
    public List<AssigneeEntity> assigneeList() {
        return registerService.getAssigneeList();
    }

}
