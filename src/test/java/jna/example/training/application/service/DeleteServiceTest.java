package jna.example.training.application.service;

import jna.example.training.domain.service.DeleteService;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteServiceTest {

    @Mock
    private EmployeeMapper employeeMapper;

    @Autowired
    private DeleteService service;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        service = new DeleteService(employeeMapper);
    }

    @DisplayName("Normal Test")
    @Test
    public void normal_test(){
        doNothing().when(employeeMapper).delete("1");
        service.delete("1");
        verify(employeeMapper).delete("1");
    }
}
