package jna.example.training.application.controller;

import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.RegisterResource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.RegisterService;
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

    /*
        画面から受け取る値が未入力、未設定ならnullを設定するためのメソッド
     */
    @InitBinder
    public void initbinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @GetMapping("/register")
    public String init(@ModelAttribute RegisterRequest registerRequest, Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute RegisterRequest registerRequest, BindingResult result, Model model) {
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

        model.addAttribute("complete", messageSource.getMessage("register.complete", null, Locale.JAPAN));


        return "register";
    }

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

        //registerRequest.setPhoto(files.get(0));

        return data.toString();
    }

    @ModelAttribute("photo")
    public String photoInit(Model model) {
        return "/images/square-image.png";
    }

    @ModelAttribute("sexItemList")
    public List<SexEntity> sexItemList() {
        return registerService.getSexList();
    }

    @ModelAttribute("birthPlaceList")
    public List<PrefecturesEntity> birthPlaceList() {
        return registerService.getPrefecturesList();
    }

    @ModelAttribute("assigneeList")
    public HashMap<String, String> assigneeList() {
        return new LinkedHashMap<String, String>() {{
            put("1", "神奈川営業所");
            put("2", "新宿営業所");
            put("3", "大阪営業所");
            put("4", "福岡営業所");
            put("5", "仙台営業所");
            put("6", "宇都宮営業所");
            put("7", "大宮営業所");
            put("8", "名古屋営業所");
        }};
    }

}
