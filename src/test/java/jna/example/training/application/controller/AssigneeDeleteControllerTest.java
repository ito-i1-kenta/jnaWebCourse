package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.application.resource.AssigneeResponse;
import jna.example.training.domain.service.AssigneeService;
import jna.example.training.domain.service.RegisterService;
import jna.example.training.infrastructure.entity.AssigneeEntity;
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

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AssigneeDeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // Controller 内で DI している Service は mock にする
    @MockBean
    private AssigneeService assigneeService;
    @MockBean
    private RegisterService registerService;

    @Autowired
    AssigneeDeleteController target;

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

        int id = 0;
        AssigneeResponse assigneeResponse = new AssigneeResponse(new ArrayList<AssigneeEntity>());
        doNothing().when(assigneeService).delete(id);
        when(registerService.getAssigneeList()).thenReturn(assigneeResponse.getAssigneeEntityList());

        mockMvc.perform(MockMvcRequestBuilders.get("/assigneeDelete/"+id))

                // レスポンスのステータスコードが200であることを検証する
                .andExpect(status().isOk());

        verify(assigneeService).delete(id);
    }
}
