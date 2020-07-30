package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.application.resource.EditorRequest;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.EditorService;
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
public class EditorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditorService editorService;

    @Autowired
    EditorController target;

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

        EditorRequest editorRequest = new EditorRequest();
        editorRequest.empNo = "012345";
        editorRequest.userName = "test";
        editorRequest.password = "test";
        editorRequest.birthDate = "2020-06-02";
        editorRequest.sex = "0";
        editorRequest.birthPlace = "1";
        editorRequest.nickName = "tester";
        editorRequest.assignee = "1";
        editorRequest.photo = "";

        Register_Editor_Resource resource = Register_Editor_Resource.create(
                EmpNo.of(editorRequest.empNo),
                UserName.of(editorRequest.userName),
                Password.of(editorRequest.password),
                BirthDate.of(editorRequest.birthDate),
                SexId.of(editorRequest.sex),
                BirthPlaceId.of(editorRequest.birthPlace),
                NickName.of(editorRequest.nickName),
                AssigneeId.of(editorRequest.assignee),
                Photo.of(editorRequest.photo)
        );

        doNothing().when(editorService).edit(resource);

        mockMvc.perform(MockMvcRequestBuilders.post("/editor")
                .flashAttr("editorRequest", editorRequest))
                .andExpect(status().isOk())
                .andExpect(view().name("editor"));;

        verify(editorService).edit(resource);
    }
}
