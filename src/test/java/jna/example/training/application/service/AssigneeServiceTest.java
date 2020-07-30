package jna.example.training.application.service;

import jna.example.training.domain.service.AssigneeService;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.mapper.AssigneesMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AssigneeServiceTest {

    @Mock
    private AssigneesMapper assigneesMapper;

    @Autowired
    private AssigneeService service;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        service = new AssigneeService(assigneesMapper);
    }

    @DisplayName("normal_test")
    @Test
    public void normal_test() throws Exception{
        AssigneeEntity assigneeEntity = AssigneeEntity.builder()
                .assigneeId(1)
                .assigneeName("test")
                .build();
        when(assigneesMapper.searchById(1)).thenReturn(assigneeEntity);
        assertThat(service.searchById(1), is(assigneeEntity));

        doNothing().when(assigneesMapper).save(isA(String.class));
        service.save("save");
        verify(assigneesMapper).save(isA(String.class));

        doNothing().when(assigneesMapper).delete(isA(Integer.class));
        service.delete(1);
        verify(assigneesMapper).delete(isA(Integer.class));

        doNothing().when(assigneesMapper).edit(isA(AssigneeEntity.class));
        service.edit(assigneeEntity);
        verify(assigneesMapper).edit(isA(AssigneeEntity.class));
    }
}
