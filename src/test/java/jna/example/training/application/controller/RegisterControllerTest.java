package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.RegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // Controller 内で DI している Service は mock にする
    @MockBean
    private RegisterService registerService;

    @Autowired
    RegisterController target;

    ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
        mapper = new ObjectMapper();
    }

    @DisplayName("Normal Test")
    @Test
    public void normal_test() throws Exception {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.empNo = "012345";
        registerRequest.userName = "テスト";
        registerRequest.password = "test";
        registerRequest.birthDate = "2020-06-02";
        registerRequest.sex = "0";
        registerRequest.birthPlace = "1";
        registerRequest.nickName = "テスター";
        registerRequest.assignee = "1";
        registerRequest.photo = "";

        Register_Editor_Resource resource = Register_Editor_Resource.create(
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
        doNothing().when(registerService).register(resource);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .flashAttr("registerRequest", registerRequest))

                // レスポンスのステータスコードが200であることを検証する
                .andExpect(status().isOk())
                .andExpect(view().name("register"));

        verify(registerService).register(resource);
    }

}

/*
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /register
       Parameters = {}
          Headers = []
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = jna.example.training.application.controller.RegisterController
           Method = jna.example.training.application.controller.RegisterController#register(RegisterRequest, BindingResult, Model)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = register
             View = null
        Attribute = photo
            value = /images/square-image.png
        Attribute = sexItemList
            value = []
        Attribute = birthPlaceList
            value = []
        Attribute = assigneeList
            value = []
        Attribute = registerRequest
            value = RegisterRequest(empNo=012345, userName=テスト, password=test, birthDate=2020-06-02, sex=0, birthPlace=1, nickName=テスター, assignee=1, photo=)
           errors = []
        Attribute = complete
            value = 登録が完了しました

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Language:"en"]
     Content type = null
             Body =
    Forwarded URL = /WEB-INF/jsp/view/register.jsp
   Redirected URL = null
          Cookies = []
 */