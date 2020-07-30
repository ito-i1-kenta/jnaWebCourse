package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.application.resource.AssigneeRequest;
import jna.example.training.domain.service.AssigneeService;
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
public class AssigneeEditorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Controller 内で DI している Service は mock にする
    @MockBean
    private AssigneeService assigneeService;

    @Autowired
    AssigneeEditorController target;

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

        AssigneeRequest assigneeRequest = new AssigneeRequest();
        assigneeRequest.setAssigneeId("1");
        assigneeRequest.setAssigneeName("test");
        doNothing().when(assigneeService).edit(assigneeRequest.getAssigneeEntity());

        mockMvc.perform(MockMvcRequestBuilders.post("/assigneeEditor")
                .flashAttr("assigneeRequest",assigneeRequest))

                // レスポンスのステータスコードが200であることを検証する
                .andExpect(status().isOk())
                .andExpect(view().name("assigneeEditor"));

        verify(assigneeService).edit(assigneeRequest.getAssigneeEntity());
    }

}
