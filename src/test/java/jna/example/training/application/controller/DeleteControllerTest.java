package jna.example.training.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jna.example.training.domain.service.DeleteService;
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
public class DeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // Controller 内で DI? しているService は mock にする???
    @MockBean
    private DeleteService deleteService;

    @Autowired
    DeleteController target;

    ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
        mapper = new ObjectMapper();
    }

    @DisplayName("Delete Test")
    @Test
    public void delete_test() throws Exception {
        String empNo = "000000";

        doNothing().when(deleteService).delete(empNo);

        mockMvc.perform(MockMvcRequestBuilders.post("/delete/"+empNo)
                .flashAttr("empNo", empNo))

                // レスポンスのステータスコードが200であることを検証する
                .andExpect(status().isOk());

        verify(deleteService).delete(empNo);
    }
}
