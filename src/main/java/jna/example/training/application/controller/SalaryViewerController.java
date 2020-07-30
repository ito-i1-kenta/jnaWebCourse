package jna.example.training.application.controller;

import jna.example.training.application.resource.SalaryViewerRequest;
import jna.example.training.application.resource.SalaryViewerResponse;
import jna.example.training.domain.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

import static org.springframework.util.CollectionUtils.isEmpty;

@Controller
@AllArgsConstructor
public class SalaryViewerController {
    protected final MessageSource messageSource;
    protected final SalaryService salaryService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 未入力のStringをnullに設定する
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/salaryViewer")
    public String init(@ModelAttribute SalaryViewerRequest salaryViewerRequest,
            Model model){
        return "salaryViewer";
    }

    @PostMapping("/salaryViewer")
    public String viewer(@ModelAttribute SalaryViewerRequest salaryViewerRequest,
                         BindingResult result,
                         @ModelAttribute SalaryViewerResponse salaryViewerResponse,
                         Model model){
        if(result.hasErrors()){
            return "salaryViewer";
        }
        salaryViewerResponse.setResponseEntityList(salaryService.getSalaryApi(salaryViewerRequest).getResponseEntityList());
        if(isEmpty(salaryViewerResponse.getResponseEntityList())){
            model.addAttribute("error",messageSource.getMessage("salaryViewer.error", null, Locale.JAPAN));
        }
        return "salaryViewer";
    }
}
