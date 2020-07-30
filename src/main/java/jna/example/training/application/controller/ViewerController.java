package jna.example.training.application.controller;

import jna.example.training.application.resource.*;
import jna.example.training.domain.object.EmpNo;
import jna.example.training.domain.object.UserName;
import jna.example.training.domain.service.ViewerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ViewerController {

    private final ViewerService viewerService;

    /*
        初期表示
     */
    @GetMapping("/viewer")
    public String init(@ModelAttribute ViewerSearchRequest viewerSearchRequest, Model model) {
        // viewer.htmlの呼び出し
        return "viewer";
    }

    /*
        社員情報一覧検索API
     */
    @GetMapping("/viewer/search")
    public String search(@ModelAttribute ViewerSearchRequest viewerSearchRequest, @ModelAttribute ViewerResponse ViewerResponse, Model model) {

        ViewerResource resource = new ViewerResource();
        resource.setViewerSearchConditionResource(
                ViewerSearchConditionResource.create(
                        Optional.ofNullable(viewerSearchRequest.getEmpNo()).map(EmpNo::of).orElse(null),
                        Optional.ofNullable(viewerSearchRequest.getUserName()).map(UserName::of).orElse(null)
                ));

        // 検索処理
        // 検索処理
        List<ViewerResponseResource> list = viewerService.search(resource);

        // レスポンス値の設定
        resource.setViewerResponseResource(list);
        ViewerResponse.factory(resource.getViewerResponseResource());

        return "viewer";
    }

}
