package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.RegisterResource;
import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.BirthDate;
import jna.example.training.domain.object.BirthPlaceId;
import jna.example.training.domain.object.EmpNo;
import jna.example.training.domain.object.NickName;
import jna.example.training.domain.object.Password;
import jna.example.training.domain.object.Photo;
import jna.example.training.domain.object.SexId;
import jna.example.training.domain.object.UserName;
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

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    public void testGet__Ok() throws Exception {

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
        doNothing().when(registerService).register(resource);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .flashAttr("registerRequest", registerRequest))

                // レスポンスのステータスコードが200であることを検証する
                .andExpect(status().isOk());


//        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
//                // レスポンスのステータスコードが200であることを検証する
//                .andExpect(status().isOk())
//                // レスポンスボディが「Hello World」であることを検証する
//                .andExpect(content().string("Hello World"));

        verify(registerService).register(resource);
    }

}
